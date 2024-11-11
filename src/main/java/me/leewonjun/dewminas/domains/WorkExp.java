package me.leewonjun.dewminas.domains;

import jakarta.persistence.*;
import lombok.*;
import me.leewonjun.dewminas.domains.sectiondatefields.CommonDateField;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "work_exp")
public class WorkExp extends CommonDateField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "to_now", nullable = false)
    private Boolean toNow;

    @ManyToOne
    @JoinColumn(name = "resume_id", nullable = false)
    private Resume resume;

    @Builder
    public WorkExp(String companyName, String jobTitle, LocalDateTime fromDate, LocalDateTime toDate, Boolean toNow) {
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.toNow = toNow;
    }
}
