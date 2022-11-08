package com.mustache.bbs.controller;

import com.mustache.bbs.domain.dto.ArticleDto;
import com.mustache.bbs.domain.entity.Article;
import com.mustache.bbs.domain.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value="/articles")
@Slf4j
public class ArticleController {
    //스프링이 articleRepo 구현체(articleDao)를 DI (인터페이스가 아님)
    //기능 ; findbyid, save .. 등
    private final ArticleRepository articleRepository;
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    @GetMapping(value = "/main")
    public String gotoMain(){
        return "articles/main";
    }
    @GetMapping(value = "/ex")
    public String exTemplate(@RequestParam String name,Model model){
        model.addAttribute("name",name);
        return "templateEx";
    }
    @GetMapping(value = "/delete")
    public String deleteAll(){
        articleRepository.deleteAll();
        return "articles/new";
    }
    @GetMapping(value= "/list")
    public String findAll(Model model) {
        List<Article> list = articleRepository.findAll();
        model.addAttribute("list",list);
        return "articles/findall";
    }
    @GetMapping(value = "/new")
    public String newArticleForm(){
        return "articles/new";
    }
    @PostMapping(value="/posts")
    public String createArticle(ArticleDto form){
        log.info(form.toString());

        Article article = articleRepository.save(form.toEntity());
        return String.format("redirect:/articles/%d",article.getId());
    }

    @GetMapping("/{id}")
    public String selectSingle(@PathVariable Long id, Model model){
        Optional<Article> optional = articleRepository.findById(id);
        if(!optional.isEmpty()){
            model.addAttribute("article",optional.get());
            return "show";
        }else{
            return "error";
        }
    }
    @GetMapping("")
    public String index(){
        return "redirect:/articles/list";
    }

}
