package com.mustache.bbs.service;


import com.mustache.bbs.domain.dto.article.ArticleDto;
import com.mustache.bbs.domain.entity.Article;
import com.mustache.bbs.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    public ArticleDto getArticle(Long id){
        Optional<Article> optArticle = articleRepository.findById(id);
        Article article = optArticle.get();
        ArticleDto articleDto = Article.of(article);
        return articleDto;
    }


}
