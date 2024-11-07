package me.leewonjun.dewminas;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.leewonjun.dewminas.domains.Resume;
import me.leewonjun.dewminas.domains.User;
import me.leewonjun.dewminas.dto.RegisterResumeRequest;
import me.leewonjun.dewminas.repositories.ResumeRepository;
import me.leewonjun.dewminas.repositories.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
이력서 CURD 테스트용 클래스
 */


@SpringBootTest
@AutoConfigureMockMvc
public class ResumeApiTest {
    public final String src = "/api/resume";
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;


    @BeforeEach
    public void mockSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        resumeRepository.deleteAll();
        userRepository.deleteAll();
    }

    @DisplayName("postResume() : 이력서 등록에 성공한다.")
    @Test
    public void postingTest() throws Exception{
        // given : 유저 데이터 저장, 이력서 정보 post
        User newUser = userRepository.save(User.builder().email("mail@gmail.com").nickname("tester").password("1234").build());
        String url = src;
        String pnum = "01012341111";
        // 전송할 이력서 기본 정보
        RegisterResumeRequest request = new RegisterResumeRequest(newUser.getEmail(), pnum);

        // when
        ResultActions res = mockMvc.perform(
                post(url)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request))
        );

        // then
        res.andExpect(status().isCreated());
        Resume newResume = resumeRepository.findByOwner(newUser).get();
        Assertions.assertThat(newResume).isNotNull();
        Assertions.assertThat(newResume.getOwner().getId()).isEqualTo(newUser.getId());
        Assertions.assertThat(newResume.getPhoneNumber()).isEqualTo(pnum);
        Assertions.assertThat(newResume.getOwner().getNickname()).isEqualTo(newUser.getNickname());
        Assertions.assertThat(newResume.getOwner().getEmail()).isEqualTo(newUser.getEmail());
    }

    @DisplayName("findResume() : 이력서 조회에 성공한다.")
    @Test
    public void findingTest() throws Exception{
        // given
        User newUser = userRepository.save(User.builder().email("mail@gmail.com").nickname("tester").password("1234").build());
        String pnum = "01012341111";
        Resume newResume = resumeRepository.save(Resume.builder().owner(newUser).phoneNumber(pnum).build());
        String url = src+"/{email}";

        // when
        ResultActions actions = mockMvc.perform(get(url, newUser.getEmail()).accept(MediaType.APPLICATION_JSON));

        // then
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$.resumeId").value(newResume.getId()));
        actions.andExpect(jsonPath("$.phoneNumber").value(newResume.getPhoneNumber()));
        actions.andExpect(jsonPath("$.email").value(newUser.getEmail()));
    }
}
