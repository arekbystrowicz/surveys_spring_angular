package com.cafetamine.surveys.user;

import com.cafetamine.surveys.survey.SurveyService;
import org.springframework.web.bind.annotation.*;


@RestController
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
    public User signIn(@RequestParam User user) {
        return this.userService.create(user);
    }

    @PostMapping("/{id}")
    public User update(@RequestParam User user) {
        return this.userService.update(user);
    }

    @PostMapping(params = {"id={id}", "action=delete"})
    public User archive(@RequestParam("id") Long id) {
        User user = this.userService.delete(id);
        this.surveyService.deleteAllByAuthor(user);

        return user;
    }

}
