package me.leewonjun.dewminas.services;

import lombok.RequiredArgsConstructor;
import me.leewonjun.dewminas.repositories.project_repo.ProjectRepository;
import me.leewonjun.dewminas.repositories.project_repo.RoleRepository;
import me.leewonjun.dewminas.repositories.project_repo.SkillRepository;
import me.leewonjun.dewminas.repositories.project_repo.TroubleshootingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProejctService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private TroubleshootingRepository troubleshootingRepository;



}
