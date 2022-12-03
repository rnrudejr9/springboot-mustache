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
    private Long id;
    private String content;
    private String title;

    @Override
    public String toString(){
        return this.content + " " + this.id + " " + this.title;
    }
    public Article toEntity(){
        return new Article(title,content);
    }

}
