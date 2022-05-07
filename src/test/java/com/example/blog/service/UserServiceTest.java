package com.example.blog.service;

import com.example.blog.ConfigTest;
import com.example.blog.model.User;
import com.example.blog.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class UserServiceTest extends ConfigTest {

    @Autowired
    UserService userService;

    @Autowired
    private UserRepository repository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    private String id = "1";

    @Test
    void createUser() {
        when(passwordEncoder.encode(userPassword)).thenReturn("12345");
        User user = userService.createUser("test2", userPassword);
        assertThat(user).isNotNull();
    }

    @Test
    void findByLogin() {
        User user = userService.findByLogin(userLogin);
        assertThat(user).isNotNull();
    }

    @Test
    void findById() {
        User user = userService.findById(id);
        assertThat(user).isNotNull();
    }

    @Test
    void deleteById() {
        repository.deleteById(id);
        User user = userService.findById(id);
        assertThat(user).isNull();
    }

    @Test
    void existById() {
        Boolean exists = repository.existsById(id);
        assertThat(exists).isTrue();
    }
}