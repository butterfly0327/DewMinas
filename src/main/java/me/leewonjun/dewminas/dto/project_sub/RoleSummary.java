package me.leewonjun.dewminas.dto.project_sub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.leewonjun.dewminas.domains.Role;
import me.leewonjun.dewminas.domains.Updatable;
import me.leewonjun.dewminas.dto.resume_sub.Specifiable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleSummary implements Specifiable {
    private Long id;
    private String roleTitle;
    private String roleComment;

    @Override
    public Updatable<? extends Specifiable> specify() {
        return Role.builder().roleTitle(this.roleTitle).roleComment(this.roleComment).build();
    }

}
