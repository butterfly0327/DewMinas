package me.leewonjun.dewminas.domains;

import me.leewonjun.dewminas.dto.resume_summaries.Specifiable;

public interface Updatable<T> extends Contrastable {
    public abstract boolean updateData(T summary);
    public abstract Long getId();
    public abstract void setResume(Resume resume);
}
