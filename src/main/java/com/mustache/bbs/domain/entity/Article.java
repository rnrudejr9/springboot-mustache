package com.mustache.bbs.domain.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


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
    private String contents;

    public Article(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
