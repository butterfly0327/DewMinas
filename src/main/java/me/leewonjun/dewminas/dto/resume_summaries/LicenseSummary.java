package me.leewonjun.dewminas.dto.resume_summaries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.leewonjun.dewminas.domains.License;
import me.leewonjun.dewminas.domains.Summarizable;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LicenseSummary implements Specifiable{
    private Long id;
    private String name; // 자격증 명
    private String organizationName;
    private LocalDateTime issuedAt;

    public LicenseSummary(License license) {
        this.id = license.getId();
        this.name = license.getName();
        this.organizationName = license.getOrganizationName();
        this.issuedAt = license.getIssuedAt();
    }

    @Override
    public Summarizable specify() {
        return License.builder()
                .name(this.name)
                .organizationName(this.organizationName)
                .issuedAt(this.issuedAt)
                .build();
    }
}
