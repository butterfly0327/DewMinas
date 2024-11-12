package me.leewonjun.dewminas.domains;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.leewonjun.dewminas.domains.sectiondatefields.CommonDateField;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "projects")
public class Project extends CommonDateField implements Summarizable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "short_comment", nullable = false)
    private String shortComment;

    @Column(nullable = false)
    private String summary;

    @ManyToOne
    @JoinColumn(name="resume_id")
    private Resume resume;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rep_img")
    private ProjectPhoto repImage;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<ProjectPhoto> photos = new ArrayList<>();

    @OneToMany(mappedBy = "id.project", fetch = FetchType.LAZY)
    private List<Skill> skills = new ArrayList<>();

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<Troubleshooting> troubleshootings = new ArrayList<>();

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "id.project", fetch = FetchType.LAZY)
    private List<RepositoryLink> repositoryLinks = new ArrayList<>();

    @OneToMany(mappedBy = "id.project", fetch = FetchType.LAZY)
    private List<ProjectSource> projectSources = new ArrayList<>();

    @Builder
    public Project(String title, String shortComment, String summary, Resume resume) {
        this.title = title;
        this.shortComment = shortComment;
        this.summary = summary;
        this.resume = resume;
    }
}
