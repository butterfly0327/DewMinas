package me.leewonjun.dewminas.services;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import me.leewonjun.dewminas.domains.Resume;
import me.leewonjun.dewminas.dto.ResumeRequest;
import me.leewonjun.dewminas.repositories.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResumeService {
    @Autowired
    private final ResumeRepository resumeRepository;

    public Resume findResume(ResumeRequest request) {
        String email = "";
        return resumeRepository.findByOwner(email).orElseThrow(()->new IllegalArgumentException("No such owner exists"));
    }

}
