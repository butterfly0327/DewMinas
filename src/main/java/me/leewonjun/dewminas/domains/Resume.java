package me.leewonjun.dewminas.domains;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude = {"educations", "workExps", "awards", "academicActivities"})
@NoArgsConstructor
@Entity(name = "resumes")
@EntityListeners(value = AuditingEntityListener.class)
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @OneToOne
    @JoinColumn(name="owner_email")
    private User owner;

//    @Column(name = "color_scheme", nullable = false)
//    private Long colorScheme;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    // foreign key photo_id references resume_photos(id)
    @OneToOne
    @JoinColumn(name = "photo_id")
    private ResumePhoto resumePhoto;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public Resume(String phoneNumber, User owner) {
        this.phoneNumber = phoneNumber;
        this.owner = owner;
    }

    @OneToMany(mappedBy = "resume")
    private ArrayList<Education> educations = new ArrayList<>();

    @OneToMany(mappedBy = "resume")
    private ArrayList<Award> awards = new ArrayList<>();

    @OneToMany(mappedBy = "resume")
    private ArrayList<EducationalExp> eduExps = new ArrayList<>();

    @OneToMany(mappedBy = "resume")
    private ArrayList<AcademicActivity> academicActivities = new ArrayList<>();

    @OneToMany(mappedBy = "resume")
    private ArrayList<WorkExp> workExps = new ArrayList<>();

    @OneToMany(mappedBy = "resume_id")
    private ArrayList<Project> projects = new ArrayList<>();
}
