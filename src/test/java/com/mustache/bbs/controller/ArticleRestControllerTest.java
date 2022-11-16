package com.mustache.bbs.controller;

import com.mustache.bbs.domain.dto.ArticleDto;
import com.mustache.bbs.domain.entity.Article;
import com.mustache.bbs.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticleRestController.class)
class ArticleRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ArticleService articleService;

    @Test
    @DisplayName("아이디 조회해서 데이터 값 받아지는가?")
    public void jsonResponse() throws Exception {
        ArticleDto articleDto = new ArticleDto(1L,"1","1");
        given(articleService.getArticle(1L)).willReturn(articleDto);
        Long id = 1L;
        String url = String.format("/api/v1/articles/%d", id);
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.title").value("1"))
                .andExpect(jsonPath("$.content").exists())
                .andExpect(jsonPath("$.content").value("1"))
                .andDo(print());
        verify(articleService).getArticle(1L);
    }

}