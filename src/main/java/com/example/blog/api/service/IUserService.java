package com.example.blog.api.service;

import com.example.blog.enumerated.RoleType;
import com.example.blog.model.User;
import org.jetbrains.annotations.Nullable;

public interface IUserService extends IEntityService<User>{
    User findByLogin(String login);

    void createUser(@Nullable final String login, @Nullable final String password, @Nullable final RoleType roleType);
}
