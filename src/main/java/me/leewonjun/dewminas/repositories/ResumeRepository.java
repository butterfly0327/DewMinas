package me.leewonjun.dewminas.repositories;

import lombok.RequiredArgsConstructor;
import me.leewonjun.dewminas.domains.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
    public abstract Optional<Resume> findByOwner(String owner);
}
