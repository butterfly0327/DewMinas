package me.leewonjun.dewminas.controllers;

import lombok.RequiredArgsConstructor;
import me.leewonjun.dewminas.domains.Resume;
import me.leewonjun.dewminas.dto.RegisterResumeRequest;
import me.leewonjun.dewminas.dto.ResumeResponse;
import me.leewonjun.dewminas.dto.UpdateResumeRequest;
import me.leewonjun.dewminas.services.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RequiredArgsConstructor
@RestController
public class ResumeApiController {

    @Autowired
    private final ResumeService resumeService;

    @GetMapping("/api/resume/{email}")
    public ResponseEntity<ResumeResponse> findResume(@PathVariable(name = "email") String email) {
        Resume resume = resumeService.findResume(email);
        // Null pointer Exception 발생
        Objects.requireNonNull(resume, ()->"No such resume +"+email);
        ResumeResponse response = new ResumeResponse(resume);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 리다이렉트는 자바 스크립트로 구현할 것. 여기선 상태 코드 전송.
    @PostMapping("/api/resume")
    public ResponseEntity<String> postResume(@RequestBody RegisterResumeRequest request) {
        resumeService.registerResume(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/api/resume/{id}")
    public ResponseEntity updateResume(@PathVariable(name = "id") Long id, @RequestBody UpdateResumeRequest request) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/api/resume/{email}")
    public ResponseEntity deleteResume(@PathVariable(name = "email") String email) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
