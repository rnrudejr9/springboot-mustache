package com.mustache.bbs.domain.entity;


import com.mustache.bbs.domain.dto.ArticleDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


//GeneratedValue : auto increasement

@Entity
@NoArgsConstructor
@Table(name = "article")
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static ArticleDto of(Article article){
        return new ArticleDto(article.id, article.title, article.content);
    }
}
