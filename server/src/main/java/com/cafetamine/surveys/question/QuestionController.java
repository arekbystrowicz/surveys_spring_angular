package com.cafetamine.surveys.question;

import org.springframework.web.bind.annotation.*;

import com.cafetamine.surveys.survey.SurveyService;


@RestController
@RequestMapping("questions")
public class QuestionController {

    private QuestionService questionService;
    private SurveyService surveyService;

    public QuestionController(QuestionService questionService, SurveyService surveyService) {
        this.questionService = questionService;
        this.surveyService = surveyService;
    }

    @GetMapping(params = {"survey_id={id}", "action=solve"})
    public Iterable<Question> getBySurvey(@RequestParam("survey_id") Long id) {
        return this.questionService.getAllBySurvey(this.surveyService.getPublishedById(id));
    }

    @GetMapping(params = {"survey_id={id}", "action=workspace"})
    public Iterable<Question> getWorkspaceBySurvey(@RequestParam("survey_id") Long id) {
        return this.questionService.getAllBySurvey(this.surveyService.getUnpublishedById(id));
    }

    @PostMapping(params = {"action=create"})
    public Question create(@RequestBody Question question) {
        return this.questionService.create(question);
    }

    @PostMapping("/{id}")
    public Question update(@RequestBody Question question) {
        return this.questionService.update(question);
    }

}
