package me.leewonjun.dewminas.domains;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.leewonjun.dewminas.dto.resume_summaries.AwardSummary;
import me.leewonjun.dewminas.dto.resume_summaries.Specifiable;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "awards")
public class Award implements Summarizable, Updatable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name="award_name", nullable = false)
    private String awardName;

    @Column(name="competition_name", nullable = false)
    private String competitionName;

    @Column(name = "organization_name", nullable = false)
    private String organizationName;

    @Column(name= "award_date", nullable = false)
    private LocalDateTime awardedDate;

    @ManyToOne
    @JoinColumn(name="resume_id", nullable = false)
    private Resume resume;

    @Builder
    public Award(String awardName, String competitionName, String organizationName, LocalDateTime awardedDate, Resume resume) {
        this.awardName = awardName;
        this.competitionName = competitionName;
        this.organizationName = organizationName;
        this.awardedDate = awardedDate;
        this.resume = resume;
    }

    @Override
    public boolean updateData(Specifiable summary) {
        boolean res = false;
        AwardSummary awardSummary = (AwardSummary) summary;
        if(!this.awardName.equals(awardSummary.getAwardName())) {
            this.awardName = awardSummary.getAwardName(); res = true;
        }
        if(!this.competitionName.equals(awardSummary.getCompetitionName())) {
            this.competitionName = awardSummary.getCompetitionName(); res = true;
        }
        if(!this.organizationName.equals(awardSummary.getOrganizationName())) {
            this.organizationName = awardSummary.getOrganizationName(); res = true;
        }
        if(!this.awardedDate.equals(awardSummary.getAwardedDate())) {
            this.awardedDate = LocalDateTime.of(awardSummary.getAwardedDate().toLocalDate(),
                                                awardSummary.getAwardedDate().toLocalTime()); res = true;
        }
        return res;
    }
}
