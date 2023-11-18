package com.fag.thomas.springbalho.thomasUsers.controllers;

import com.fag.thomas.springbalho.thomasUsers.entities.User;
import com.fag.thomas.springbalho.thomasUsers.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public String findAll(Model model) {
        List<User> users = repository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("newUser", new User());
        return "index";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        try {
            User user = repository.findById(id).orElse(null);
            model.addAttribute("user", user);
            return "user";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @PostMapping
    public String insert(@ModelAttribute User newUser) {
        try {
            repository.save(newUser);
            return "redirect:/users";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/search")
    public String showSearchPage(Model model) {
        try {

            List<User> searchResults = repository.searchByNameIgnoreCase("example");
            model.addAttribute("searchResults", searchResults);
            return "search";
        } catch (Exception e) {

            return "error";
        }
    }
}

