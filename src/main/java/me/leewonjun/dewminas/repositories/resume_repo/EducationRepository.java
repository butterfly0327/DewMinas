package me.leewonjun.dewminas.repositories.resume_repo;

import me.leewonjun.dewminas.domains.of_resume.Education;
import me.leewonjun.dewminas.domains.of_resume.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> findByResume(Resume resume);
    void deleteAllByResume(Resume resume);
}
