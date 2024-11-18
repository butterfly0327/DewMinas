package me.leewonjun.dewminas.dto.resume_sub;

import lombok.*;
import me.leewonjun.dewminas.domains.Education;
import me.leewonjun.dewminas.domains.Updatable;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationSummary implements Specifiable{
    private Long id;
    private int type; // 교육 타입 : 고등학교, 대학교
    private String institutionName; // 기관 명
    private String major; // 전공, 고등학교의 경우 - 인문계, 상업계, 공업계 etc..
    // type = 1 대학인 경우
    private String degree; // 학위
    private double gpa; // 학점
    private double maxGpa; // 기준 학점
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private Boolean toNow;
    // 학적 - 중퇴 = 0, 재학 = 1, 휴학 = 2, 졸업 = 3, 졸업 예정 = 4;
    private int status;

    @Builder
    public EducationSummary(int type, String institutionName, String major,
                            String degree, Double gpa, Double maxGpa, LocalDateTime fromDate,
                            LocalDateTime toDate, Boolean toNow, int status) {
        this.type = type;
        this.institutionName = institutionName;
        this.major = major;
        this.degree = degree;
        this.gpa = gpa;
        this.maxGpa = maxGpa;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.toNow = toNow;
        this.status = status;
    }

    public EducationSummary(Education edu) {
        this.type = edu.getType();
        this.institutionName = edu.getInstitutionName();
        this.major = edu.getMajor();
        this.degree = edu.getDegree();
        this.gpa = edu.getGpa();
        this.maxGpa = edu.getMaxGpa();
        this.fromDate = edu.getFromDate();
        this.toDate = edu.getToDate();
        this.toNow = edu.getToNow();
        this.status = edu.getStatus();
        this.id = edu.getId();
    }

    @Override
    public Updatable<EducationSummary> specify() {
        return Education.builder()
                .type(this.type)
                .institutionName(this.institutionName)
                .degree(this.degree)
                .major(this.major)
                .status(this.status)
                .gpa(this.gpa)
                .maxGpa(this.maxGpa)
                .fromDate(this.fromDate)
                .toDate(this.toDate)
                .toNow(this.toNow)
                .build();
    }
}
