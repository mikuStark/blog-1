package com.example.blog.service;

import com.example.blog.api.service.IRoleService;
import com.example.blog.model.Role;
import com.example.blog.repo.RoleRepository;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService extends EntityService<Role> implements IRoleService {

    @Autowired
    RoleRepository repository;

    @Override
    @NotNull
    @SneakyThrows
    public List<Role> findAllByUserId(@NotNull final String userId) {
        return repository.findAllByUserId(userId);
    }
}
