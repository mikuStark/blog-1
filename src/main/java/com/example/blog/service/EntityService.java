package com.example.blog.service;

import com.example.blog.api.service.IEntityService;

public class EntityService<E> implements IEntityService<E> {
    @Override
    public E findById(String id) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Boolean existById(String id) {
        return null;
    }
}
