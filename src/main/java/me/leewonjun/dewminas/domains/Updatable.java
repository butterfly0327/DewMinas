package me.leewonjun.dewminas.domains;

import me.leewonjun.dewminas.dto.resume_summaries.Specifiable;

public interface Updatable {
    public abstract boolean updateData(Specifiable summary);
}
