package com.cafetamine.surveys.user;

import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("http://localhost:4200")
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
    public User signIn(@RequestBody User user) {
        return this.userService.create(user);
    }

    @PutMapping(value = "/{id}")
    public User update(@RequestBody User user, @PathVariable("id") Long id) {
        return this.userService.update(id, user);
    }

    @DeleteMapping(value = "/{id}")
    public User archive(@PathVariable Long id) {
        User user = this.userService.delete(id);
        // TODO what with surveys after he leaves?

        return user;
    }

}
