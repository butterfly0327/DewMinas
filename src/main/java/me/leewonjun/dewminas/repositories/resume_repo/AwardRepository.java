package me.leewonjun.dewminas.repositories.resume_repo;

import me.leewonjun.dewminas.domains.of_resume.Award;
import me.leewonjun.dewminas.domains.of_resume.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AwardRepository extends JpaRepository<Award, Long> {
    List<Award> findByResume(Resume resume);
    List<Award> findByCompetitionName(String competitionName);
    void deleteAllByResume(Resume resume);
}
