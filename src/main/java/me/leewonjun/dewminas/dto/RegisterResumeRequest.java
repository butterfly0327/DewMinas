package me.leewonjun.dewminas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResumeRequest {
    // 클라이언트로부터 데이터.
    // 1. 사용자 이메일
    private String email;
    private String phoneNumber;
}
