package com.example.blog.service;

import com.example.blog.api.service.IRoleService;
import com.example.blog.api.service.IUserService;
import com.example.blog.exception.UserNotFoundException;
import com.example.blog.model.CustomUser;
import com.example.blog.model.Role;
import com.example.blog.model.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = findByLogin(login);
        if (user == null) throw new UserNotFoundException();
        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        builder = org.springframework.security.core.userdetails.User.withUsername(login);
        builder.password(user.getPasswordHash());

        @NotNull final List<Role> userRoles = roleService.findAllByUserId(user.getId());
        @NotNull final List<String> roles = new ArrayList<>();
        userRoles.forEach(t -> roles.add(t.toString()));
        builder.roles(roles.toArray(new String[]{}));

        org.springframework.security.core.userdetails.User result = null;
        result = (org.springframework.security.core.userdetails.User) builder.build();

        final CustomUser customUser = new CustomUser(result);
        customUser.setUserId(user.getId());
        return customUser;
    }

    @Nullable
    public User findByLogin(@NotNull final String login) {
        return userService.findByLogin(login);
    }
}
