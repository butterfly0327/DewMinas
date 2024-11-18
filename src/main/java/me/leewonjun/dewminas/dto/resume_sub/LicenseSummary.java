package me.leewonjun.dewminas.dto.resume_sub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.leewonjun.dewminas.domains.of_resume.License;
import me.leewonjun.dewminas.domains.Updatable;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LicenseSummary implements Specifiable{
    private Long id;
    private String licenseName; // 자격증 명
    private String organizationName;
    private LocalDateTime issuedAt;

    public LicenseSummary(License license) {
        this.id = license.getId();
        this.licenseName = license.getLicenseName();
        this.organizationName = license.getOrganizationName();
        this.issuedAt = license.getIssuedAt();
    }

    public LicenseSummary(String licenseName, String organizationName, LocalDateTime issuedAt) {
        this.licenseName = licenseName;
        this.organizationName = organizationName;
        this.issuedAt = issuedAt;
    }

    @Override
    public Updatable<LicenseSummary> specify() {
        return License.builder()
                .licenseName(this.licenseName)
                .organizationName(this.organizationName)
                .issuedAt(this.issuedAt)
                .build();
    }
}
