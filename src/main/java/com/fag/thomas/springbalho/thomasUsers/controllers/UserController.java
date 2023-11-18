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

    /**
     * Mapeamento para exibir todos os usuários.
     *
     * @param model O modelo utilizado para enviar dados para a visualização.
     * @return O nome da página (template) a ser exibida, neste caso, "index".
     */
    @GetMapping
    public String findAll(Model model) {
        List<User> users = repository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("newUser", new User());
        return "index";
    }

    /**
     * Mapeamento para exibir detalhes de um usuário específico.
     *
     * @param id    O ID do usuário a ser exibido.
     * @param model O modelo utilizado para enviar dados para a visualização.
     * @return O nome da página (template) a ser exibida, pode ser "user" ou "error" em caso de exceção.
     */
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

    /**
     * Mapeamento para inserir um novo usuário.
     *
     * @param newUser O usuário a ser inserido.
     * @return Redireciona para a página principal ("/users") após a inserção ou "error" em caso de exceção.
     */
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

    /**
     * Mapeamento para exibir a página de pesquisa.
     *
     * @param model O modelo utilizado para enviar dados para a visualização.
     * @return O nome da página (template) a ser exibida, pode ser "search" ou "error" em caso de exceção.
     */
    @GetMapping("/search")
    public String showSearchPage(Model model) {
        try {
            // Exemplo de busca por nome (substitua "example" pelo valor desejado).
            List<User> searchResults = repository.searchByNameIgnoreCase("example");
            model.addAttribute("searchResults", searchResults);
            return "search";
        } catch (Exception e) {
            return "error";
        }
    }
}
