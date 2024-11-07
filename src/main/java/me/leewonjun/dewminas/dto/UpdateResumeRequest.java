package me.leewonjun.dewminas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateResumeRequest {
    // 이력서에 입력할 정보들을 서버로 전송하는 객체
    // 저장할 정보 = 정보기입페이지에 저장되는 정보 -> 각각을 객체로 만들어 줘야함.
    // 등록과 다르게 이력서 id를 사용하기 때문에 이메일정보 불필요.
    // owner, phoneNumber는 제외.

}
