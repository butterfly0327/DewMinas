package me.leewonjun.dewminas;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.transaction.Transactional;
import me.leewonjun.dewminas.domains.*;
import me.leewonjun.dewminas.dto.RegisterResumeRequest;
import me.leewonjun.dewminas.dto.UpdateResumeRequest;
import me.leewonjun.dewminas.dto.resume_summaries.*;
import me.leewonjun.dewminas.repositories.*;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.core.Local;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
    private AcademicActivityRepository academicActivityRepository;

    @Autowired
    private AwardRepository awardRepository;

    @Autowired
    private EducationalExpRepository educationalExpRepository;

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private LicenseRepository licenseRepository;

    @Autowired
    private WorkExpRepository workExpRepository;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;


    @BeforeEach
    public void mockSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        academicActivityRepository.deleteAll();
        awardRepository.deleteAll();
        educationRepository.deleteAll();
        educationalExpRepository.deleteAll();
        licenseRepository.deleteAll();
        workExpRepository.deleteAll();
        resumeRepository.deleteAll();
        userRepository.deleteAll();
    }

    @DisplayName("postResume() : 이력서 등록에 성공한다.")
    @Test
    @Transactional
    public void postingTest() throws Exception{
        // given : 유저 데이터 저장, 이력서 정보 post

        String pnum = "01012341111";
        User newUser = userRepository.save(User.builder().nameKor("이원준").nameEng("Lee WonJun").phoneNumber("01012341111").email("mail@gmail.com").nickname("tester").password("1234").build());
        String url = src;
        // 전송할 이력서 기본 정보
        RegisterResumeRequest request = new RegisterResumeRequest(newUser.getEmail());

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
        Assertions.assertThat(newResume.getOwner().getPhoneNumber()).isEqualTo(pnum);
        Assertions.assertThat(newResume.getOwner().getNickname()).isEqualTo(newUser.getNickname());
        Assertions.assertThat(newResume.getOwner().getEmail()).isEqualTo(newUser.getEmail());
    }

    @DisplayName("findResume() : 이력서 조회에 성공한다.")
    @Test
    public void findingTest() throws Exception{
        // given
        String pnum = "01012341111";
        User newUser = userRepository.save(User.builder().nameKor("이원준").nameEng("Lee WonJun").phoneNumber(pnum).email("mail@gmail.com").nickname("tester").password("1234").build());
        Resume newResume = resumeRepository.save(Resume.builder().owner(newUser).build());
        String url = src+"/{email}";

        // when
        ResultActions actions = mockMvc.perform(get(url, newUser.getEmail()).accept(MediaType.APPLICATION_JSON));

        // then
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$.resumeId").value(newResume.getId()));
        actions.andExpect(jsonPath("$.phoneNumber").value(newResume.getOwner().getPhoneNumber()));
        actions.andExpect(jsonPath("$.email").value(newUser.getEmail()));
    }

    @DisplayName("updateResume() #1 : 이력서 정보 추가에 성공한다.")
    @Test
    @Transactional
    public void appendInformation() throws Exception {
        // given : 유저 생성, 이력서 생성, 추가할 정보 생성
        String url = src+"/{id}";

        String pnum = "01034422631";
        User owner = userRepository.save(User.builder().nameEng("Lee").phoneNumber(pnum).nameKor("이원준").nickname("tester").password("123").email("mail@gmail.com").build());
        Resume resume = resumeRepository.save(Resume.builder().owner(owner).build());
        List<EducationSummary> eduSums = new ArrayList<>();
        List<LicenseSummary> licenseSums = new ArrayList<>();
        List<AwardSummary> awardSums = new ArrayList<>();
        List<AcademicActivitySummary> acaSums = new ArrayList<>();
        List<EducationalExpSummary> eduExpSums = new ArrayList<>();
        List<WorkExpSummary> workSums = new ArrayList<>();
        String desiredPos = "Back-end developer";
        {
            // 정보 입력 스코프
            eduSums.add(new EducationSummary(0, "동의대학교", "컴퓨터공학과", "학사", 4.49, 4.5,
                    LocalDateTime.of(2014, java.time.Month.of(3), 2, 0, 0, 0),
                    LocalDateTime.of(2024, java.time.Month.of(3), 14, 0, 0, 0), true, 4));
            licenseSums.add(new LicenseSummary("정보처리기사", "산업인력공단",
                    LocalDateTime.of(2024, java.time.Month.of(6), 11, 0, 0, 0)));
            awardSums.add(new AwardSummary("우수상", "캡스톤디자인 경진대회", "동의대 LINC+사업단",
                    LocalDateTime.of(2024, java.time.Month.of(8), 20, 0, 0, 0)));
            eduExpSums.add(new EducationalExpSummary("SSAFY", "고용노동부",
                    LocalDateTime.of(2025, java.time.Month.of(1), 1, 0, 0, 0)
                    ,LocalDateTime.of(2024, java.time.Month.of(12), 31, 0, 0, 0), true ));
            acaSums.add(new AcademicActivitySummary("횡단보도 사각 보조 시스템 논문발표", "한국정보기술학회", "추계종합학술대회",
                    LocalDateTime.of(2024, java.time.Month.of(11), 22, 13, 32, 0)));
            workSums.add(new WorkExpSummary("네이버", "개발팀장",
                    LocalDateTime.of(2025,java.time.Month.of(3), 1, 0 ,0 ,0),
                    LocalDateTime.of(2025, java.time.Month.of(12), 3, 0, 0, 0), true));
        }

        UpdateResumeRequest request = new UpdateResumeRequest(desiredPos, eduSums, licenseSums, awardSums, acaSums, eduExpSums, workSums);
        // when
        mockMvc.perform(put(url, resume.getId())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(request))
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        //resumeRepository.flush();
        // fetch를 FetchType.EAGER로 변경하면 통과한다. 그런데 왜인지 모르겠다.
        // then
        Resume newResume = resumeRepository.findByOwner(owner).orElse(null);

        Assertions.assertThat(newResume).isNotNull();
        Assertions.assertThat(newResume.getOwner()).isEqualTo(owner);
        Assertions.assertThat(newResume.getDesiredPosition()).isEqualTo(desiredPos);

        //
//
//        Assertions.assertThat(newResume.getAwards().size()).isOne();
//        Assertions.assertThat(newResume.getAwards().get(0).isDifferentWith(awardSums.get(0).specify())).isFalse();
//
//        Assertions.assertThat(newResume.getAcademicActivities().size()).isOne();
//        Assertions.assertThat(newResume.getAcademicActivities().get(0).isDifferentWith(acaSums.get(0).specify())).isFalse();
//
//        Assertions.assertThat(newResume.getEducations().size()).isOne();
//        Assertions.assertThat(newResume.getEducations().get(0).isDifferentWith(eduSums.get(0).specify())).isFalse();
//
//        Assertions.assertThat(newResume.getEduExps().size()).isOne();
//        Assertions.assertThat(newResume.getEduExps().get(0).isDifferentWith(eduExpSums.get(0).specify())).isFalse();
//
//        Assertions.assertThat(newResume.getLicenses().size()).isOne();
//        Assertions.assertThat(newResume.getLicenses().get(0).isDifferentWith(licenseSums.get(0).specify())).isFalse();
//
//        Assertions.assertThat(newResume.getWorkExps().size()).isOne();
//        Assertions.assertThat(newResume.getWorkExps().get(0).isDifferentWith(workSums.get(0).specify())).isFalse();

        List<Education> educations = educationRepository.findByResume(resume);
        List<Award> awards = awardRepository.findByResume(resume);
        List<EducationalExp> educationalExps = educationalExpRepository.findByResume(resume);
        List<AcademicActivity> academicActivities = academicActivityRepository.findByResume(resume);
        List<License> licenses = licenseRepository.findByResume(resume);
        List<WorkExp> workExps = workExpRepository.findByResume(resume);

        Assertions.assertThat(educations.size()).isOne();
        Assertions.assertThat(educations.get(0).isDifferentWith(eduSums.get(0).specify())).isFalse();

        Assertions.assertThat(awards.size()).isOne();
        Assertions.assertThat(awards.get(0).isDifferentWith(awardSums.get(0).specify())).isFalse();

        Assertions.assertThat(educationalExps.size()).isOne();
        Assertions.assertThat(educationalExps.get(0).isDifferentWith(eduExpSums.get(0).specify())).isFalse();

        Assertions.assertThat(academicActivities.size()).isOne();
        Assertions.assertThat(academicActivities.get(0).isDifferentWith(acaSums.get(0).specify())).isFalse();

        Assertions.assertThat(licenses.size()).isOne();
        Assertions.assertThat(licenses.get(0).isDifferentWith(licenseSums.get(0).specify())).isFalse();

        Assertions.assertThat(workExps.size()).isOne();
        Assertions.assertThat(workExps.get(0).isDifferentWith(workSums.get(0).specify())).isFalse();

    }

    @DisplayName("updateResume() #2 : 이력서 정보 수정에 성공한다.")
    @Test
    public void updateInformation() {

    }
}
