package me.leewonjun.dewminas.domains;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.leewonjun.dewminas.domains.sectiondatefields.CommonDateField;
import me.leewonjun.dewminas.dto.resume_summaries.EducationSummary;
import me.leewonjun.dewminas.dto.resume_summaries.Specifiable;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Entity(name="educations")
public class Education extends CommonDateField implements Summarizable, Updatable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type", nullable = false)
    private Short type; // 교육기관 타입 : 고교, 대학 = GPA 출력 여부 결정

    @Column(name="institution_name", nullable = false)
    private String institutionName;

    @Column(name="department_name", nullable = false)
    private String major;

    @Column(name = "degree")
    private String degree;

    @Column(name="gpa")
    private Double gpa;

    @Column(name="max_gpa")
    private Double maxGpa;

    @Column(name="status")
    private Short status; // 학적 - 중퇴 = 0, 재학 = 1, 휴학 = 2, 졸업 = 3, 졸업 예정 = 4;

    @Column(name = "to_now", nullable = false)
    private Boolean toNow;

    @ManyToOne
    @JoinColumn(name = "resume_id", nullable = false)
    private Resume resume;

    @Builder
    public Education(Short type, String institutionName, String major, String degree, Double gpa, Short status,
                     Double maxGpa, LocalDateTime fromDate, LocalDateTime toDate, Boolean toNow, Resume resume) {
        this.type = type;
        this.status = status;
        this.institutionName = institutionName;
        this.major = major;
        this.degree = degree;
        this.gpa = gpa;
        this.maxGpa = maxGpa;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.toNow = toNow;
    }

    @Override
    public boolean updateData(Specifiable summary) {
        EducationSummary educationSummary = (EducationSummary) summary;
        boolean res = false;

        if(this.type != educationSummary.getType()) {
            this.type = educationSummary.getType(); res = true;
        }
        if(this.status != educationSummary.getStatus()) {
            this.status = educationSummary.getStatus(); res = true;
        };
        if(!this.institutionName.equals(educationSummary.getInstitutionName())){
            this.institutionName = educationSummary.getInstitutionName(); res = true;
        }
        if(this.major.equals(educationSummary.getMajor())) {
            this.major = educationSummary.getMajor(); res = true;
        }
        if(this.degree.equals(educationSummary.getDegree())){
            this.degree = educationSummary.getDegree(); res = true;
        }
        if(this.gpa != educationSummary.getGpa()) {
            this.gpa = educationSummary.getGpa(); res = true;
        }
        if(this.maxGpa != educationSummary.getMaxGpa()) {
            this.maxGpa = educationSummary.getMaxGpa(); res = true;
        }
        if(!this.fromDate.equals(educationSummary.getFromDate())) {
            this.fromDate = LocalDateTime.of(
                    educationSummary.getFromDate().toLocalDate(),
                    educationSummary.getFromDate().toLocalTime()
            ); res = true;
        }
        if(!this.toDate.equals(educationSummary.getToDate())) {
            this.toDate = LocalDateTime.of(
                    educationSummary.getToDate().toLocalDate(),
                    educationSummary.getFromDate().toLocalTime()
            ); res = true;
        }
        if(this.toNow != educationSummary.isToNow()) {
            this.toNow = educationSummary.isToNow(); res = true;
        }
        return res;
    }
}
