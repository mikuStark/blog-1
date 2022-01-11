package com.example.blog.api.service;

public interface IEntityService<E> {

    E findById(String id);

    E add(final E entity);

    void deleteById(String id);

    Boolean existById(String id);

}
