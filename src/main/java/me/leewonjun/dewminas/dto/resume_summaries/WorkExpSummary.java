package me.leewonjun.dewminas.dto.resume_summaries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.leewonjun.dewminas.domains.Summarizable;
import me.leewonjun.dewminas.domains.WorkExp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkExpSummary implements Specifiable {
    private Long id;
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
        this.id = exp.getId();
    }

    @Override
    public Summarizable specify() {
        return WorkExp.builder()
                .companyName(this.companyName)
                .jobTitle(this.jobTitle)
                .fromDate(this.fromDate)
                .toDate(this.toDate)
                .toNow(this.toNow)
                .build();
    }
}
