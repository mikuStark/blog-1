package com.example.blog.api.service;

public interface IEntityService<E> {

    E findById(String id);

    void deleteById(String id);

    Boolean existById(String id);

}
