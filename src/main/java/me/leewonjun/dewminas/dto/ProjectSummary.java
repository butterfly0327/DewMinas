package me.leewonjun.dewminas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.leewonjun.dewminas.domains.Project;

import java.util.Arrays;

/**
 * 프로젝트 요약정보 : 이력서 페이지에 출력
 * 용도 : 이력서 보여주기 정보 전달
 * 속성 : 이력서 제목, 간략한 설명, 대표 사진 url, 사용 스킬 이미지 url
 */

@Getter
@Setter
@AllArgsConstructor
public class ProjectSummary {
    private String title;
    private String shortComment;
    private String rep_photo_url;
    private String[] token_url;

    public ProjectSummary(Project original) {
        this.title = original.getTitle();
        this.shortComment = original.getShortComment();
        this.rep_photo_url = original.getRepImage() != null ? original.getRepImage().getUrl() : null;

        if(original.getSkills() == null) return;
        this.token_url = new String[original.getSkills().size()];
        Arrays.setAll(token_url, (idx)-> original.getSkills().get(idx).getId().getSkillBook().getImageUrl());

    }

}
