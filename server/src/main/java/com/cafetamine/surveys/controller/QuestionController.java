package com.cafetamine.surveys.controller;

import org.springframework.web.bind.annotation.*;

import com.cafetamine.surveys.model.Question;
import com.cafetamine.surveys.service.QuestionService;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/questions")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping()
    public Iterable<Question> getBySurvey(@RequestParam("survey_id") Long id) {
        return this.questionService.getAllBySurveyId(id);
    }

    @GetMapping("/{id}")
    public Question getById(@PathVariable Long id) {
        return this.questionService.getById(id);
    }

    @PostMapping()
    public Question create(@RequestBody Question question) {
        return this.questionService.create(question);
    }

    @PutMapping(value = "/{id}")
    public Question update(@RequestBody Question question, @PathVariable("id") Long id) {
        return this.questionService.update(id, question);
    }

    @DeleteMapping(value = "/{id}")
    public Question delete(@PathVariable Long id) {
        return this.questionService.delete(this.questionService.getById(id));
    }

}
