package com.example.blog;

import com.example.blog.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithUserDetails;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ControllerTest extends ConfigTest{

    @MockBean
    ArticleService articleService;

    @Test
    @WithUserDetails("test")
    void addArticle() throws Exception{
        mockMvc.perform(post("/all-articles/add-article")
                        .param("anons", "123")
                        .param("title", "123")
                        .param("text", "123"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/all-articles"));
    }

    @Test
    @WithUserDetails("test")
    void articleMore() throws Exception{
        when(articleService.existById(any())).thenReturn(true);
        mockMvc.perform(get("/all-articles/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("article-more"));
    }

    @Test
    @WithUserDetails("test")
    void articleMoreNotExist() throws Exception{
        when(articleService.existById(any())).thenReturn(false);
        mockMvc.perform(get("/all-articles/1"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/all-articles"));
    }
}
