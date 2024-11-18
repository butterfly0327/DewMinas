package me.leewonjun.dewminas.services;

import lombok.RequiredArgsConstructor;
import me.leewonjun.dewminas.repositories.project_repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProejctService {
    @Autowired
    private final ProjectRepository projectRepository;

    @Autowired
    private final RoleRepository roleRepository;

    @Autowired
    private final SkillRepository skillRepository;

    @Autowired
    private final TroubleshootingRepository troubleshootingRepository;

    @Autowired
    private final ProjectSourceRepository projectSourceRepository;

    @Autowired
    private final ProjectPhotoRepository projectPhotoRepository;

    public void findProject(Long projectId) {
        // 전달 받은 project ID를 이용해 프로젝트 객체를 반환한다.
        // 고려해야할 점?
    }

}
