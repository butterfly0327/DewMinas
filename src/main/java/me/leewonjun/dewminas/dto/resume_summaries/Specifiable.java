package me.leewonjun.dewminas.dto.resume_summaries;

import me.leewonjun.dewminas.domains.Summarizable;

public interface Specifiable {
    public abstract Summarizable specify();
    public Long getId();
}
