package com.example.blog.service;

import com.example.blog.api.service.IArticleService;
import com.example.blog.model.Article;
import com.example.blog.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArticleService extends EntityService<Article> implements IArticleService {

    @Autowired
    private ArticleRepository repository;

    @Override
    public Article create(String title, String anons, String text) {
        Article article = new Article(title, anons, text);
        repository.save(article);
        return article;
    }

    @Override
    public Iterable<Article> findAll() {
        return repository.findAll();
    }

    @Override
    public void updateArticle(String id, String title, String anons, String text) {
        Article article = findById(id);
        article.setTitle(title);
        article.setAnons(anons);
        article.setText(text);
        repository.save(article);
    }

    @Override
    public void incrementViews(String id) {
        Article article = findById(id);
        article.setViews(article.getViews()+1);
        repository.save(article);
    }
}
