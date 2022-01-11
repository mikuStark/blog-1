package com.example.blog.controller;

import com.example.blog.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistryController {

    @Autowired
    private IUserService userService;

    @GetMapping("/registry")
    public String registry(Model model) {
        return "registry";
    }

    @PostMapping("/registry")
    public String userRegistry(
            @RequestParam String login,
            @RequestParam String password,
            Model model) {
        userService.createUser(login, password);
        return "redirect:/";
    }
}
