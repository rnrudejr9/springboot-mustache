package com.mustache.bbs.domain.dto;

import com.mustache.bbs.domain.entity.Article;

public class ArticleRequestDto {
    private String title;
    private String content;

    //requesrDto를 엔티티로!
    public Article toEntity(ArticleRequestDto dto) {
        return new Article(dto.title,dto.content);
    }
}
