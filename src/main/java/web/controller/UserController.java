// src/main/java/web/controller/UserController.java
package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Список
    @GetMapping
    public String list(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users"; // /WEB-INF/pages/users.html
    }

    // Форма создания
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    // Форма редактирования
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "user-form";
    }

    // Создать
    @PostMapping
    public String create(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users";
    }

    // Обновить
    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute User user) {
        user.setId(id);
        userService.update(user); // важное отличие от save
        return "redirect:/users";
    }

    // Удалить
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
