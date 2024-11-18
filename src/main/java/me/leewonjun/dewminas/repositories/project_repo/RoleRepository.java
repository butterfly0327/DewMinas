package me.leewonjun.dewminas.repositories.project_repo;

import me.leewonjun.dewminas.domains.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
