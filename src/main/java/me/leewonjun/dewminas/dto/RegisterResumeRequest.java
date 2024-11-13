package me.leewonjun.dewminas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResumeRequest {
    // 클라이언트로부터 데이터.
    // 1. 사용자 이메일
    private String email;
    // json 에서 날짜를 parsing 한다. 형식 : "2024-11-11T12:34:00" 로 보낼 것. 중간의 T 주의
    // 등록 테스트. private LocalDateTime registerDate; - 필요 없음. 생성일이 Auditing 되기 때문임.
}
