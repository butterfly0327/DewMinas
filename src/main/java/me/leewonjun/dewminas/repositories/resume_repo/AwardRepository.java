package me.leewonjun.dewminas.repositories.resume_repo;

import me.leewonjun.dewminas.domains.Award;
import me.leewonjun.dewminas.domains.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AwardRepository extends JpaRepository<Award, Long> {
    List<Award> findByResume(Resume resume);
    List<Award> findByCompetitionName(String competitionName);
    void deleteAllByResume(Resume resume);
}
