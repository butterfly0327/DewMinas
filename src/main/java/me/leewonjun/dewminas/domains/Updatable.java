package me.leewonjun.dewminas.domains;

import me.leewonjun.dewminas.domains.of_resume.Resume;

public interface Updatable<T> extends Contrastable {
    public abstract boolean updateData(T summary);
    public abstract Long getId();
    public abstract void setResume(Resume resume);
}
