package com.mustache.bbs.domain.dto.article;


import com.mustache.bbs.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    public Article toEntity(){
        return new Article(title,content);
    }

}
