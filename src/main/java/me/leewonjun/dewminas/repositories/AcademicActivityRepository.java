package me.leewonjun.dewminas.repositories;

import me.leewonjun.dewminas.domains.AcademicActivity;
import me.leewonjun.dewminas.domains.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademicActivityRepository extends JpaRepository<AcademicActivity, Long> {
    public List<AcademicActivity> findByResume(Resume resume);
}
