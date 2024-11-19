package me.leewonjun.dewminas.dto.client_dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.leewonjun.dewminas.dto.project_sub.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponse {
    private Long id;
    private String title;
    private String summary;
    private String email;

    private List<RoleSummary> roles;
    private List<TroubleshootingSummary> troubleshooting;
    private List<SkillSummary> skills;
    private List<ProjectSourceSummary> projectSources;
    private List<RepositoryLinkSummary> repositoryLinks;


}
