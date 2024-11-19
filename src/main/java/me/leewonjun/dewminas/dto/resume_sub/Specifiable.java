package me.leewonjun.dewminas.dto.resume_sub;

import me.leewonjun.dewminas.domains.Updatable;

public interface Specifiable {
    // Update 연산에서 사용됨. 복합키 엔티티는 연산의 단순성을 위해 대조, 수정이 아닌 전체 삭제, 삽입으로 구현.
    public abstract Updatable<? extends Specifiable> specify();
    public Long getId();
}
