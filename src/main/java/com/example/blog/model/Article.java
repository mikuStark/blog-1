package com.example.blog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "article")
public class Article implements Serializable {

    @Id
    private String id = UUID.randomUUID().toString();

    private String title;
    private String anons;
    private String text;
    private Integer views = 0;

    public Article(String title, String anons, String text) {
        this.title = title;
        this.anons = anons;
        this.text = text;
    }
}
