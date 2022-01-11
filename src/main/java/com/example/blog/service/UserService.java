package com.example.blog.service;

import com.example.blog.api.service.IRoleService;
import com.example.blog.api.service.IUserService;
import com.example.blog.enumerated.RoleType;
import com.example.blog.exception.EmptyLoginException;
import com.example.blog.exception.EmptyPasswordException;
import com.example.blog.model.Role;
import com.example.blog.model.User;
import com.example.blog.repo.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserService extends EntityService<User> implements IUserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    private void init() {
        initUser("user", "user", RoleType.USER);
    }

    private void initUser(
            @Nullable final String login, @Nullable final String password, @Nullable final RoleType roleType
    ) {
        @Nullable final User user = repository.findByLogin(login);
        if (user != null) return;
        createUser(login, password, roleType);
    }

    public void createUser(
            @Nullable final String login, @Nullable final String password, @Nullable final RoleType roleType
    ) {
        if (login == null || login.isEmpty()) throw new EmptyLoginException();
        if (password == null || password.isEmpty()) throw new EmptyPasswordException();
        @NotNull final String passwordHash = passwordEncoder.encode(password);
        @NotNull final User user = new User();
        user.setLogin(login);
        user.setPasswordHash(passwordHash);
        Role role = new Role(roleType);
        user.getRoles().add(role);
        repository.save(user);
    }

    @Override
    public User findByLogin(String login) {
        if (login == null || login.isEmpty()) throw new EmptyLoginException();
        return repository.findByLogin(login);
    }

    @Override
    public User findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User add(User entity) {
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
