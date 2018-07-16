package com.cafetamine.surveys.controller;

import org.springframework.web.bind.annotation.*;

import com.cafetamine.surveys.model.Question;
import com.cafetamine.surveys.service.QuestionService;


@RestController
@RequestMapping("questions")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // TODO development only
    @GetMapping()
    public Iterable<Question> getAll() {
        return this.questionService.getAll();
    }

    @GetMapping("/{id}")
    public Question getById(@PathVariable Long id) {
        return this.questionService.getById(id);
    }

      // TODO parameters on source root?
//    @GetMapping(params = "survey_id={id}")
//    public Iterable<Question> getBySurvey(@RequestParam("survey_id") Long id) {
//        return this.questionService.getAllBySurvey(this.surveyService.getById(id));
//    }

    @PostMapping()
    public Question create(@RequestBody Question question) {
        return this.questionService.create(question);
    }

    @PostMapping(value = "/{id}", params = "action=update")
    public Question update(@RequestBody Question question) {
        return this.questionService.update(question);
    }

    @PostMapping(value = "/{id}", params = "action=delete")
    public Question delete(@PathVariable Long id) {
        return this.questionService.delete(this.questionService.getById(id));
    }

}
