package me.leewonjun.dewminas.dto.resume_sub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.leewonjun.dewminas.domains.Project;
import me.leewonjun.dewminas.domains.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로젝트 요약정보 : 이력서 페이지에 출력
 * 용도 : 이력서 보여주기 정보 전달
 * 속성 : 이력서 제목, 간략한 설명, 대표 사진 url, 사용 스킬 이미지 url
 */

@Getter
@Setter
@AllArgsConstructor
public class ProjectSummary {
    private Long id;
    private String title;
    private String shortComment;
    private String rep_photo_url;
    private List<String> token_url;
    private String owner;

    public ProjectSummary(Project original) {
        this.id = original.getId();
        this.title = original.getTitle();
        this.shortComment = original.getShortComment();
        this.rep_photo_url = original.getRepImage() != null ? original.getRepImage().getUrl() : null;
        this.owner = original.getOwner();

        if(original.getSkills() == null) return;
        this.token_url = new ArrayList<>();
        for(Skill skill : original.getSkills()) token_url.add(skill.getId().getSkillBook().getImageUrl());

    }

}
