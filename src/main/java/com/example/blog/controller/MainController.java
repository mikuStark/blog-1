package com.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("name", "Главная страница");
        return "main-page";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
