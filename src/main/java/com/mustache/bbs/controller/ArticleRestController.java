package com.mustache.bbs.controller;


import com.mustache.bbs.domain.dto.ArticleDto;
import com.mustache.bbs.domain.dto.ArticleResponseDto;
import com.mustache.bbs.domain.dto.HospitalResponse;
import com.mustache.bbs.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleRestController {
    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> get(@PathVariable Long id){
        ArticleDto articleDto = articleService.getArticle(id);
        return ResponseEntity.ok().body(articleDto); //RETrun : DTO
    }

}
