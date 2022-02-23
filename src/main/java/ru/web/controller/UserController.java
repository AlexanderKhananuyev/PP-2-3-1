package ru.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.web.model.User;
import ru.web.service.UserService;

// exit to main page
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/index";
    }

    @GetMapping("{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "users/info";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) { return "users/new"; }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "users/edit";
    }

    @PatchMapping("{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute("user") User user) {
        userService.updateUserById(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
