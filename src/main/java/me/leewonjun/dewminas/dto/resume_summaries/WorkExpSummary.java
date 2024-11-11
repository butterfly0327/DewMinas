package me.leewonjun.dewminas.dto.resume_summaries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.leewonjun.dewminas.domains.WorkExp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkExpSummary {
    private String companyName;
    private String jobTitle;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private Boolean toNow;

    public WorkExpSummary(WorkExp exp) {
        this.companyName = exp.getCompanyName();
        this.jobTitle = exp.getJobTitle();
        this.fromDate = exp.getFromDate();
        this.toDate = exp.getToDate();
        this.toNow = exp.getToNow();
    }
}
