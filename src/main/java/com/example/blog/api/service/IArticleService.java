package com.example.blog.api.service;

import com.example.blog.model.Article;

public interface IArticleService extends IEntityService<Article>{

    Article create(String title, String anons, String text);

    Iterable<Article> findAll();

    void updateArticle(String id, String title, String anons, String text);

    void incrementViews(String id);
}
