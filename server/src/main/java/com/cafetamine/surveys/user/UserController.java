package com.cafetamine.surveys.user;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public Iterable<User> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return this.userService.getById(id);
    }

    @PostMapping()
    public User signIn(@RequestParam User user) {
        return this.userService.create(user);
    }

}
