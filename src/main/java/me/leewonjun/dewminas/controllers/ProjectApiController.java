package me.leewonjun.dewminas.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ProjectApiController {

    @GetMapping("/api/project/{id}")
    public ResponseEntity findProject(@PathVariable("id") Long projectId) {

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/api/project")
    public ResponseEntity registerProject(
 //           @RequestBody RegisterProejctRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/api/project/{id}")
    public ResponseEntity updateProject (
            //@RequestBody UpdateProjectRequest request
    ){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/project/{id}")
    public ResponseEntity deleteProject(@PathVariable("id") Long id) {
        return ResponseEntity.ok().build();
    }
}
