package me.leewonjun.dewminas.dto;

import lombok.Getter;
import lombok.Setter;
import me.leewonjun.dewminas.domains.*;
import me.leewonjun.dewminas.dto.resume_summaries.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class ResumeResponse {
    /*
    이력서 정보 전달용 객체 필요 정보 수합 필요.
    1. 이력서 프로필 정보 -> 컬렉션으로 모아서 전달 (ArrayList)
    2. 이력서 프로젝트 정보 -> 전용 객체 생성이 필요. 프로젝트 사진 경로, 프로젝트 설명, 프로젝트 제목, 스킬 토큰 etc..
     */
    private Long resumeId;
    private String email;
    private String phoneNumber;
    private String profilePhotoUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<EducationSummary> educationList;
    private List<AwardSummary> awardList;
    private List<EducationalExpSummary> eduExpList;
    private List<AcademicActivitySummary> acaActList;
    private List<WorkExpSummary> workExpList;

    private List<ProjectSummary> projects;

    public ResumeResponse(Resume resume) {
        this.resumeId = resume.getId();
        this.email = resume.getOwner().getEmail();
        this.phoneNumber = resume.getPhoneNumber();

        this.createdAt = resume.getCreatedAt();
        this.updatedAt = resume.getUpdatedAt();

        this.profilePhotoUrl = (resume.getResumePhoto() != null ? resume.getResumePhoto().getUrl() : null);
        this.educationList = (resume.getEducations() != null ? resume.getEducations().stream().map(EducationSummary::new).collect(Collectors.toList()) : null);
        this.awardList = (resume.getAwards() != null ? resume.getAwards().stream().map(AwardSummary::new).collect(Collectors.toList()) : null);
        this.eduExpList = (resume.getEduExps() != null ? resume.getEduExps().stream().map(EducationalExpSummary::new).collect(Collectors.toList()) : null);
        this.acaActList = (resume.getAcademicActivities() != null ? resume.getAcademicActivities().stream().map(AcademicActivitySummary::new).collect(Collectors.toList()) : null);
        this.workExpList = (resume.getWorkExps() != null ? resume.getWorkExps().stream().map(WorkExpSummary::new).collect(Collectors.toList()) : null);

        this.projects = (resume.getProjects() != null) ? (resume.getProjects().stream().map(ProjectSummary::new).collect(Collectors.toList())) : null;
    }


}
