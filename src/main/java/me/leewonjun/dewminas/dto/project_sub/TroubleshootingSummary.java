package me.leewonjun.dewminas.dto.project_sub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.leewonjun.dewminas.domains.Updatable;
import me.leewonjun.dewminas.dto.resume_sub.Specifiable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TroubleshootingSummary implements Specifiable {

    @Override
    public Updatable<? extends Specifiable> specify() {
        return null;
    }

    @Override
    public Long getId() {return 0L;}
}
