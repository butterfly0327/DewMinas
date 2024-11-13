package me.leewonjun.dewminas.domains;

import jakarta.persistence.*;
import lombok.*;
import me.leewonjun.dewminas.domains.sectiondatefields.CommonDateField;
import me.leewonjun.dewminas.dto.resume_summaries.WorkExpSummary;
import org.hibernate.jdbc.Work;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "work_exp")
public class WorkExp extends CommonDateField implements Updatable<WorkExpSummary> {
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

    @Override
    public boolean updateData(WorkExpSummary summary) {
        boolean res = false;
        if(!this.companyName.equals(summary.getCompanyName())) {
            this.companyName = summary.getCompanyName(); res = true;
        }
        if(!this.jobTitle.equals(summary.getJobTitle())) {
            this.jobTitle = summary.getJobTitle(); res = true;
        }
        if(!this.fromDate.equals(summary.getFromDate())) {
            this.fromDate = LocalDateTime.of(summary.getFromDate().toLocalDate(), summary.getFromDate().toLocalTime());
            res = true;
        }
        if(!this.toDate.equals(summary.getToDate())) {
            this.toDate = LocalDateTime.of(summary.getToDate().toLocalDate(), summary.getToDate().toLocalTime());
            res = true;
        }
        if(this.toNow != summary.getToNow()) {
            this.toNow = summary.getToNow();
            res = true;
        }
        return res;
    }

    @Override
    public boolean isDifferentWith(Object o) {
        WorkExp other = (WorkExp) o;
        return !(this.companyName.equals(other.companyName)
                && this.jobTitle.equals(other.getJobTitle())
                && this.fromDate.toLocalDate().equals(other.getFromDate().toLocalDate())
                && this.toDate.toLocalDate().equals(other.getToDate().toLocalDate())
                && this.toNow.equals(other.getToNow()));
    }

    @SuppressWarnings("rawtypes")
    public boolean equals(Object obj) {
        if(!(obj instanceof WorkExp)) return false;
        Updatable up = (Updatable)obj;
        return up.getId().equals(this.id);
    }
}
