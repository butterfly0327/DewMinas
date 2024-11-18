package me.leewonjun.dewminas.domains;

public interface Updatable<T> extends Contrastable {
    public abstract boolean updateData(T summary);
    public abstract Long getId();
    public abstract void setResume(Resume resume);
}
