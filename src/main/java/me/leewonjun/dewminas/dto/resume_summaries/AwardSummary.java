package me.leewonjun.dewminas.dto.resume_summaries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.leewonjun.dewminas.domains.Award;
import me.leewonjun.dewminas.domains.Summarizable;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AwardSummary implements Specifiable{
    private Long id;
    private String awardName;
    private String competitionName;
    private String organizationName;
    private LocalDateTime awardedDate;

    public AwardSummary(Award award) {
        this.awardName = award.getAwardName();
        this.competitionName = award.getCompetitionName();
        this.organizationName = award.getOrganizationName();
        this.awardedDate = award.getAwardedDate();
        this.id = award.getId();
    }

    @Override
    public Summarizable specify() {
        return Award.builder()
                .awardedDate(this.awardedDate)
                .competitionName(this.competitionName)
                .organizationName(this.organizationName)
                .awardName(this.awardName)
                .build();
    }
}
