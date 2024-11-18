package me.leewonjun.dewminas.dto.resume_sub;

import me.leewonjun.dewminas.domains.Updatable;

public interface Specifiable {
    public abstract Updatable<? extends Specifiable> specify();
    public Long getId();
}
