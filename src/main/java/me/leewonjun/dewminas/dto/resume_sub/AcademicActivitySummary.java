package me.leewonjun.dewminas.dto.resume_sub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.leewonjun.dewminas.domains.AcademicActivity;
import me.leewonjun.dewminas.domains.Updatable;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AcademicActivitySummary implements Specifiable {
    private Long id;
    private String activityName;
    private String institutionName;
    private String conferenceName;
    private LocalDateTime activityDate;

    public AcademicActivitySummary(AcademicActivity activity) {
        this.activityName = activity.getActivityName();
        this.institutionName = activity.getInstitutionName();
        this.conferenceName = activity.getConferenceName();
        this.activityDate = activity.getActivityDate();
        this.id = activity.getId();
    }

    public AcademicActivitySummary(String activityName, String institutionName, String conferenceName, LocalDateTime activityDate) {
        this.activityDate = activityDate;
        this.activityName = activityName;
        this.institutionName= institutionName;
        this.conferenceName = conferenceName;
    }

    @Override
    public Updatable<AcademicActivitySummary> specify() {
        return AcademicActivity.builder()
                .activityName(this.activityName)
                .conferenceName(this.conferenceName)
                .activityDate(this.activityDate)
                .academicInstitution(this.institutionName)
                .build();
    }

}
