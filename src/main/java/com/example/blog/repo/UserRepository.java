package com.example.blog.repo;

import com.example.blog.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    User findByLogin(String login);
}
