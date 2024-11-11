package me.leewonjun.dewminas.domains;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.leewonjun.dewminas.domains.sectiondatefields.CommonDateField;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Entity(name="educations")
public class Education extends CommonDateField {
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

}
