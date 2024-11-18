package me.leewonjun.dewminas.repositories.resume_repo;

import me.leewonjun.dewminas.domains.of_resume.AcademicActivity;
import me.leewonjun.dewminas.domains.of_resume.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademicActivityRepository extends JpaRepository<AcademicActivity, Long> {
    public List<AcademicActivity> findByResume(Resume resume);
    void deleteAllByResume(Resume resume);
}
