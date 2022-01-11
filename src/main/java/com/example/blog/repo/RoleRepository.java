package com.example.blog.repo;

import com.example.blog.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, String> {
    List<Role> findAllByUserId(String userId);
}
