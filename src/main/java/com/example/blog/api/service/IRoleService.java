package com.example.blog.api.service;

import com.example.blog.model.Role;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface IRoleService extends IEntityService<Role>{
    @NotNull
    @SneakyThrows
    List<Role> findAllByUserId(@NotNull String userId);
}
