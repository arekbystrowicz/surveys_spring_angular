package com.cafetamine.surveys.controller;

import org.springframework.web.bind.annotation.*;

import com.cafetamine.surveys.model.User;
import com.cafetamine.surveys.service.SurveyService;
import com.cafetamine.surveys.service.UserService;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("users")
public class UserController {

    private UserService userService;
    private SurveyService surveyService;

    public UserController(UserService userService, SurveyService surveyService) {
        this.userService = userService;
        this.surveyService = surveyService;
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

    // TODO when json w/o id is sent -> it's just m::create
    // TODO  will prbl disperse with actual update implementation but keep eye
    @PostMapping(value = "/{id}", params = "action=update")
    public User update(@RequestBody User user) {
        return this.userService.update(user);
    }

    @PostMapping(value = "/{id}", params = "action=delete")
    public User archive(@PathVariable Long id) {
        User user = this.userService.delete(id);
        // TODO what witch surveys after he leaves?

        return user;
    }

}
