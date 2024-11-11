package me.leewonjun.dewminas.dto.resume_summaries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.leewonjun.dewminas.domains.Award;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AwardSummary {
    private String awardName;
    private String competitionName;
    private String organizationName;
    private LocalDateTime awardedDate;

    public AwardSummary(Award award) {
        this.awardName = award.getAwardName();
        this.competitionName = award.getCompetitionName();
        this.organizationName = award.getOrganizationName();
        this.awardedDate = award.getAwardedDate();
    }
}
