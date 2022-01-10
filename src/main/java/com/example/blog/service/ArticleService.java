package com.example.blog.service;

import com.example.blog.exception.NotFoundId;
import com.example.blog.model.Article;
import com.example.blog.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArticleService {

    @Autowired
    private ArticleRepository repository;

    public Article create(String title, String anons, String text) {
        Article article = new Article(title, anons, text);
        repository.save(article);
        return article;
    }

    public Iterable<Article> findAll() {
        return repository.findAll();
    }

    public Article findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public Boolean existById(String id) {
        return repository.existsById(id);
    }

    public void updateArticle(String id, String title, String anons, String text) {
//        Article article = repository.findById(id).orElseThrow(NotFoundId::new);
        Article article = findById(id);
        article.setTitle(title);
        article.setAnons(anons);
        article.setText(text);
        repository.save(article);
    }
}
