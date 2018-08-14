package com.cafetamine.surveys.controller;

import org.springframework.web.bind.annotation.*;

import com.cafetamine.surveys.model.Question;
import com.cafetamine.surveys.service.QuestionService;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("surveys/{survey_id}/questions")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping()
    public Iterable<Question> getBySurvey(@PathVariable("survey_id") Long id) {
        return this.questionService.getAllBySurveyId(id);
    }

    @GetMapping(value = "/{question_id}")
    public Question getById(@PathVariable("question_id") Long id) {
        return this.questionService.getById(id);
    }

    @PostMapping()
    public Question create(@PathVariable("survey_id") Long surveyId, @RequestBody Question question) {
        return this.questionService.create(question);
    }

    @PutMapping(value = "/{question_id}")
    public Question update(@PathVariable("question_id") Long id, @RequestBody Question question) {
        return this.questionService.update(id, question);
    }

    @DeleteMapping(value = "/{question_id}")
    public Question delete(@PathVariable("question_id") Long id) {
        return this.questionService.delete(this.questionService.getById(id));
    }

}
