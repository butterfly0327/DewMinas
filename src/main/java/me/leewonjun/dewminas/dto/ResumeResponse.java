package me.leewonjun.dewminas.dto;

import lombok.Getter;
import lombok.Setter;
import me.leewonjun.dewminas.domains.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
    private ArrayList<Education> educationList;
    private ArrayList<Award> awardList;
    private ArrayList<EducationalExp> eduExpList;
    private ArrayList<AcademicActivity> acaActList;
    private ArrayList<WorkExp> workExpList;

    private ProjectSummary[] summaries;

    public ResumeResponse(Resume resume) {
        this.resumeId = resume.getId();
        this.email = resume.getOwner().getEmail();
        this.phoneNumber = resume.getPhoneNumber();

        this.createdAt = resume.getCreatedAt();
        this.updatedAt = resume.getUpdatedAt();

        this.profilePhotoUrl = (resume.getResumePhoto() != null ? resume.getResumePhoto().getUrl() : null);
        this.educationList = (resume.getEducations() != null ? resume.getEducations() : null);
        this.awardList = (resume.getAwards() != null ? resume.getAwards() : null);
        this.eduExpList = (resume.getEduExps() != null ? resume.getEduExps() : null);
        this.acaActList = (resume.getAcademicActivities() != null ? resume.getAcademicActivities() : null);
        this.workExpList = (resume.getWorkExps() != null ? resume.getWorkExps() : null);

        ArrayList<Project> projects = resume.getProjects();
        if(projects != null) {
            this.summaries = new ProjectSummary[projects.size()];
            for(int i = 0; i < summaries.length; i++) this.summaries[i] = new ProjectSummary(projects.get(i));
        }

    }


}
