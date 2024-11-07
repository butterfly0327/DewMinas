package me.leewonjun.dewminas.services;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import me.leewonjun.dewminas.domains.Resume;
import me.leewonjun.dewminas.domains.User;
import me.leewonjun.dewminas.dto.RegisterResumeRequest;
import me.leewonjun.dewminas.dto.ResumeRequest;
import me.leewonjun.dewminas.repositories.ResumeRepository;
import me.leewonjun.dewminas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResumeService {
    @Autowired
    private final ResumeRepository resumeRepository;

    @Autowired
    private final UserRepository userRepository;

    public Resume findResume(String email) {
        User owner = userRepository.findByEmail(email).orElseThrow(()->new IllegalArgumentException("No such email exists"));
        return resumeRepository.findByOwner(owner).orElseThrow(()->new IllegalArgumentException("No such owner exists"));
    }

    public void registerResume(RegisterResumeRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(()-> new IllegalArgumentException("no such user email"));
        Resume resume = Resume.builder().owner(user).phoneNumber(request.getPhoneNumber()).build();
        resumeRepository.save(resume);

    }


}
