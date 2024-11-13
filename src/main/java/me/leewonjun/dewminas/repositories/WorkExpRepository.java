package me.leewonjun.dewminas.repositories;

import me.leewonjun.dewminas.domains.EducationalExp;
import me.leewonjun.dewminas.domains.Resume;
import me.leewonjun.dewminas.domains.WorkExp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkExpRepository extends JpaRepository<WorkExp, Long> {
    List<WorkExp> findByResume(Resume resume);
}
