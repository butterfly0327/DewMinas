package me.leewonjun.dewminas.dto.resume_sub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.leewonjun.dewminas.domains.Award;
import me.leewonjun.dewminas.domains.Updatable;

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

    public AwardSummary(String awardName, String competitionName, String organizationName, LocalDateTime awardedDate) {
        this.awardName = awardName;
        this.competitionName = competitionName;
        this.awardedDate = awardedDate;
        this.organizationName = organizationName;
    }

    @Override
    public Updatable<AwardSummary> specify() {
        return Award.builder()
                .awardedDate(this.awardedDate)
                .competitionName(this.competitionName)
                .organizationName(this.organizationName)
                .awardName(this.awardName)
                .build();
    }
}
