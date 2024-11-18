package me.leewonjun.dewminas.repositories.resume_repo;

import me.leewonjun.dewminas.domains.EducationalExp;
import me.leewonjun.dewminas.domains.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationalExpRepository extends JpaRepository<EducationalExp, Long> {
    List<EducationalExp> findByResume(Resume resume);
    void deleteAllByResume(Resume resume);
}