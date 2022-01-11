package com.example.blog.service;

import com.example.blog.api.service.IUserService;
import com.example.blog.exception.EmptyLoginException;
import com.example.blog.model.User;
import com.example.blog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserService extends EntityService<User> implements IUserService {

    @Autowired
    UserRepository repository;

//    @PostConstruct
//    private void init() {
//        initUser("admin", "admin", RoleType.ADMIN);
//        initUser("user", "user", RoleType.USER);
//    }

    @Override
    public User findByLogin(String login) {
        if (login == null || login.isEmpty()) throw new EmptyLoginException();
        return repository.findByLogin(login);
    }
}
