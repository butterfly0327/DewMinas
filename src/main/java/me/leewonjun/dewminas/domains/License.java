package me.leewonjun.dewminas.domains;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "organization_name", nullable = false)
    private String issuing_organization;

    @Column(name = "issuedDate", nullable = false)
    private LocalDateTime issuedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    @Builder
    public License(String name, String organization, LocalDateTime issuedAt) {
        this.name = name;
        this.issuing_organization = organization;
        this.issuedAt = issuedAt;
    }
}
