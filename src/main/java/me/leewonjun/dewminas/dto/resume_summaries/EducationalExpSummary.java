package me.leewonjun.dewminas.dto.resume_summaries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.leewonjun.dewminas.domains.EducationalExp;
import me.leewonjun.dewminas.domains.Summarizable;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationalExpSummary implements Specifiable{
    private Long id;
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
        this.id = exp.getId();
    }

    @Override
    public Summarizable specify() {
        return EducationalExp.builder()
                .educationName(this.educationName)
                .organizationName(this.organizationName)
                .fromDate(this.fromDate)
                .toDate(this.toDate)
                .toNow(this.toNow)
                .build();
    }
}
