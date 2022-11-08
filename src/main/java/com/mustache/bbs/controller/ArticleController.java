package com.mustache.bbs.controller;

import com.mustache.bbs.domain.dto.ArticleDto;
import com.mustache.bbs.domain.entity.Article;
import com.mustache.bbs.domain.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/articles")
@Slf4j
public class ArticleController {

    private final ArticleRepository articleRepository;
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    @GetMapping(value = "/ex")
    public String exTemplate(@RequestParam String name,Model model){
        model.addAttribute("name",name);
        return "templateEx";
    }
    @GetMapping(value = "/delete")
    public String deleteAll(){
        articleRepository.deleteAll();
        return "/articles/new";
    }
    @GetMapping(value= "/findall")
    public String findAll() {
        List<Article> list = articleRepository.findAll();

        return "articles/findall";
    }
    @GetMapping(value = "/new")
    public String newArticleForm(){
        return "articles/new";
    }
    @PostMapping(value="/posts")
    public String createArticle(ArticleDto form){
        log.info(form.toString());
        Article article = form.toEntity();
        articleRepository.save(article);
        log.info("insert 성공");
        return "articles/new";
    }

}
