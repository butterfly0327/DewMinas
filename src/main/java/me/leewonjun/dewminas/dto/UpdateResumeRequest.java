package me.leewonjun.dewminas.dto;

import lombok.Getter;
import lombok.Setter;
import me.leewonjun.dewminas.domains.WorkExp;
import me.leewonjun.dewminas.dto.resume_summaries.*;

import java.util.List;

@Getter
@Setter
public class UpdateResumeRequest {
    // 이력서에 입력할 정보들을 서버로 전송하는 객체
    // 저장할 정보 = 정보기입페이지에 저장되는 정보 -> 각각을 객체로 만들어 줘야함.
    // 등록과 다르게 이력서 id를 사용하기 때문에 이메일정보 불필요.
    // owner, phoneNumber는 제외.
    // 일단 사진 파일은 제외하고 텍스트 정보부터 전송함.

    // 기본 프로필 정보, 이름(한글), 이름(영문) - 모두 User 테이블에 이미 저장됨.
    // 원하는 개발 직무 ex) Back-end developer
    // 수정을 위한 정보가 필요.
    // 이력서 수정 페이지 -> 기존 엔티티 모아서 전달
    // id 값도 함께 전달 필요. 아래 summary들에 id도 추가할 것.
    private String desiredPosition;
    private List<EducationSummary> educations;
    private List<LicenseSummary> licenses;
    private List<AwardSummary> awards;
    private List<AcademicActivitySummary> academicActivities;
    private List<EducationalExpSummary> eduExps;
    private List<WorkExpSummary> workExps;
}

/* 이력서 등록된 상태
*  1. 이력서 수정 버튼 클릭
*  2. 이력서 수정 페이지로 감
*  3. 이미 저장된 이력서 데이터 -> ResumeResponse
*  4. 수정된 이력서 데이터 전송 -> UpdateResumeRequest
* */