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

    @GetMapping(value = "/delete")
    public String deleteAll(){
        articleRepository.deleteAll();
        return "articles/new";
    }

    //@REquestParam /index=1&page=2 변수가 여러개를 다루고 싶을때 <- 을 사용해야되나요
    //@Pathvariable  /3 이런식
    //모텔에서 veiw로 데이터를 전달하는데 저희가 만들고 있는 view
    //null 값 넣을때 id 값을 추가했는지

    @GetMapping(value="/{id}/delete")
    public String delete(@PathVariable Long id,Model model){
        articleRepository.deleteById(id);
        model.addAttribute("msg","정상적인 삭제");
        return "redirect:/articles/list";
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

    @PostMapping ("/{id}")
    public String updateQuery(ArticleDto form,Model model){
        Article article = form.toEntity();
        articleRepository.save(article);
        log.info(article.getId() + " " +article.getTitle());
        model.addAttribute("article",article);
        return "show";
    }

    @GetMapping("/{id}/edit")
    public String updateTitle(@PathVariable Long id, Model model){
        Optional<Article> optional =articleRepository.findById(id);
        log.info(optional.get().getTitle());
        if(!optional.isEmpty()){
            model.addAttribute("article",optional.get());
            return "articles/edit";
        }else{
            return "error";
        }
    }

}
