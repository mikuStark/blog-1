package com.example.blog.api.service;

import com.example.blog.model.User;

public interface IUserService extends IEntityService<User>{
    User findByLogin(String login);
}
