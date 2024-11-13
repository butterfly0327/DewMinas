package me.leewonjun.dewminas.dto.resume_summaries;

import me.leewonjun.dewminas.domains.Updatable;

public interface Specifiable {
    public abstract Updatable<? extends Specifiable> specify();
    public Long getId();
}
