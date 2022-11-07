package com.mustache.bbs.domain.dto;


import lombok.Getter;

@Getter
public class ArticleDto {
    private String content;
    private Long id;
    private String title;

    public ArticleDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString(){
        return this.content + " " + this.id + " " + this.title;
    }

}
