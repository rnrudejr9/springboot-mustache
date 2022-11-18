package com.mustache.bbs.domain.dto;


import com.mustache.bbs.domain.entity.Article;
import lombok.Getter;

@Getter
public class ArticleResponseDto {
    private Long id;
    private String title;
    private String content;

    public ArticleResponseDto(long l, String title, String content) {
        this.title = title;
        this.content = content;
    }


    public Article toEntity() {
        return new Article(this.id, this.title, this.content);
    }
}
