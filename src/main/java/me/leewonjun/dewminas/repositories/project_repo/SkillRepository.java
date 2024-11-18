package me.leewonjun.dewminas.repositories.project_repo;

import me.leewonjun.dewminas.domains.compositekeys.ProjectSkillPk;
import me.leewonjun.dewminas.domains.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, ProjectSkillPk> {
}
