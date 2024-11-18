package me.leewonjun.dewminas.repositories.project_repo;

import me.leewonjun.dewminas.domains.Troubleshooting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TroubleshootingRepository extends JpaRepository<Troubleshooting, Long> {

}
