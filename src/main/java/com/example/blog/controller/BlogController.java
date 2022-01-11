package com.example.blog.controller;

import com.example.blog.api.service.IArticleService;
import com.example.blog.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {

    @Autowired
    private IArticleService articleService;

    @GetMapping("/all-articles")
    public String getAllArticles(Model model) {
        Iterable<Article> articles = articleService.findAll();
        model.addAttribute("articles", articles);
        return "all-articles";
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/all-articles/add-article")
    public String addArticle(Model model) {
        return "add-article";
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PostMapping("/all-articles/add-article")
    public String addPostArticle(
            @RequestParam String title,
            @RequestParam String anons,
            @RequestParam String text,
            Model model) {
        articleService.create(title, anons, text);
        return "redirect:/all-articles";
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/all-articles/{id}")
    public String articleMore(@PathVariable(value = "id") String id, Model model) {
        if (!articleService.existById(id)) {
            return "redirect:/all-articles";
        }
        articleService.incrementViews(id);
        model.addAttribute("article", articleService.findById(id));
        return "article-more";
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/all-articles/{id}/edit")
    public String articleEdit(@PathVariable(value = "id") String id, Model model) {
        if (!articleService.existById(id)) {
            return "redirect:/all-articles";
        }
        model.addAttribute("article", articleService.findById(id));
        return "edit-article";
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PostMapping("/all-articles/{id}/edit")
    public String articleUpdateEdit(
            @PathVariable(value = "id") String id,
            @RequestParam String title,
            @RequestParam String anons,
            @RequestParam String text,
            Model model) {
        if (!articleService.existById(id)) {
            return "redirect:/all-articles";
        }
        articleService.updateArticle(id, title, anons, text);
        return "redirect:/all-articles/"+id;
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PostMapping("/all-articles/{id}/delete")
    public String articleDelete(@PathVariable(value = "id") String id, Model model) {
        if (!articleService.existById(id)) {
            return "redirect:/all-articles";
        }
        articleService.deleteById(id);
        return "redirect:/all-articles";
    }
}
