package me.leewonjun.dewminas.repositories;

import me.leewonjun.dewminas.domains.EducationalExp;
import me.leewonjun.dewminas.domains.License;
import me.leewonjun.dewminas.domains.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseRepository extends JpaRepository<License, Long> {
    List<License> findByResume(Resume resume);
}