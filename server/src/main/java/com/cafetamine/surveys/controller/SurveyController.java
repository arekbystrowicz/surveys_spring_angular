package com.cafetamine.surveys.controller;

import org.springframework.web.bind.annotation.*;

import com.cafetamine.surveys.model.Survey;
import com.cafetamine.surveys.service.UserService;
import com.cafetamine.surveys.service.SurveyService;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("surveys")
public class SurveyController {

    private SurveyService surveyService;
    private UserService userService;

    public SurveyController(SurveyService surveyService, UserService userService) {
        this.surveyService = surveyService;
        this.userService = userService;
    }

    @GetMapping()
    public Iterable<Survey> getAll() {
        return this.surveyService.getAll();
    }

    @GetMapping("/{id}")
    public Survey getById(@PathVariable Long id) {
        return this.surveyService.getById(id);
    }

    @GetMapping(params = "user_id={id}")
    public Iterable<Survey> getByAuthor(@RequestParam Long id) {
        return this.surveyService.getByAuthor(this.userService.getById(id));
    }

    @PostMapping()
    public Survey create(@RequestBody Survey survey) {
        return this.surveyService.create(survey);
    }

    @PostMapping(value = "/{id}", params = "action=update")
    public Survey update(@RequestBody Survey survey) {
        return this.surveyService.update(survey);
    }

    @PostMapping(value = "/{id}", params = "action=delete")
    public Survey delete(@PathVariable Long id) {
        return this.surveyService.delete(id);
    }

}