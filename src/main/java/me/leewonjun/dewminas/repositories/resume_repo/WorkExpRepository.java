package me.leewonjun.dewminas.repositories.resume_repo;

import me.leewonjun.dewminas.domains.of_resume.Resume;
import me.leewonjun.dewminas.domains.of_resume.WorkExp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkExpRepository extends JpaRepository<WorkExp, Long> {
    List<WorkExp> findByResume(Resume resume);
    List<WorkExp> findByCompanyName(String companyName);
    void deleteAllByResume(Resume resume);
}
