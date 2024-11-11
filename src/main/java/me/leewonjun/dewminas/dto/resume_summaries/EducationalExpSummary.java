package me.leewonjun.dewminas.dto.resume_summaries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.leewonjun.dewminas.domains.EducationalExp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationalExpSummary {
    private String educationName;
    private String organizationName;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private Boolean toNow;

    public EducationalExpSummary(EducationalExp exp) {
        this.educationName = exp.getEducationName();
        this.organizationName = exp.getOrganizationName();
        this.fromDate = exp.getFromDate();
        this.toDate = exp.getToDate();
        this.toNow = exp.getToNow();
    }
}
