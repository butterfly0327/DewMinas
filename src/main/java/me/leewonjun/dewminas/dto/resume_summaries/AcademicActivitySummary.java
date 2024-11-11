package me.leewonjun.dewminas.dto.resume_summaries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.leewonjun.dewminas.domains.AcademicActivity;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AcademicActivitySummary {
    private String activityName;
    private String institutionName;
    private String conferenceName;
    private LocalDateTime activityDate;

    public AcademicActivitySummary(AcademicActivity activity) {
        this.activityName = activity.getActivityName();
        this.institutionName = activity.getInstitutionName();
        this.conferenceName = activity.getConferenceName();
        this.activityDate = activity.getActivityDate();
    }
}
