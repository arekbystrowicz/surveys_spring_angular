package com.cafetamine.surveys.question;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

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

}
