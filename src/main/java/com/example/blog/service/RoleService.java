package com.example.blog.service;

import com.example.blog.api.service.IRoleService;
import com.example.blog.model.Role;
import com.example.blog.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends EntityService<Role> implements IRoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public Role findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Role add(Role entity) {
        if (entity == null) return null;
        repository.save(entity);
        return entity;
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public Boolean existById(String id) {
        return repository.existsById(id);
    }
}
