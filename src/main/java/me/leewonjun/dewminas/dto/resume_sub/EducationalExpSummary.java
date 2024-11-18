package me.leewonjun.dewminas.dto.resume_sub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.leewonjun.dewminas.domains.EducationalExp;
import me.leewonjun.dewminas.domains.Updatable;

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

    public EducationalExpSummary(String educationName, String organizationName, LocalDateTime fromDate, LocalDateTime toDate, boolean toNow) {
        this.educationName = educationName;
        this.organizationName = organizationName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.toNow = toNow;
    }

    @Override
    public Updatable<EducationalExpSummary> specify() {
        return EducationalExp.builder()
                .educationName(this.educationName)
                .organizationName(this.organizationName)
                .fromDate(this.fromDate)
                .toDate(this.toDate)
                .toNow(this.toNow)
                .build();
    }
}
