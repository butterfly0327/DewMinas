package me.leewonjun.dewminas.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.leewonjun.dewminas.domains.Resume;
import me.leewonjun.dewminas.domains.Updatable;
import me.leewonjun.dewminas.domains.User;
import me.leewonjun.dewminas.dto.RegisterResumeRequest;
import me.leewonjun.dewminas.dto.UpdateResumeRequest;
import me.leewonjun.dewminas.dto.resume_summaries.Specifiable;
import me.leewonjun.dewminas.repositories.ResumeRepository;
import me.leewonjun.dewminas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    @Transactional
    public void updateResume(Long id, UpdateResumeRequest request) {
        Resume resume = resumeRepository.findById(id).orElseThrow(()->new IllegalArgumentException("no such resume id : " + id));
        resume.setDesiredPosition(request.getDesiredPosition()); // Dirty checking
        
        // 갱신 또는 추가 수행 메소드
        updateOrSave(resume, request.getAcademicActivities());
        updateOrSave(resume, request.getAwards());
        updateOrSave(resume, request.getEducations());
        updateOrSave(resume, request.getEduExps());
        updateOrSave(resume, request.getLicenses());
        updateOrSave(resume, request.getWorkExps());

    }

    private <T extends Updatable> void updateOrSave(Resume resume, List<? extends Specifiable> list) {
        if(Objects.isNull(list) || list.isEmpty()) return; // 비었거나 null이면 바로 종료

    }
}
