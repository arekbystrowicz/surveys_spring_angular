package com.cafetamine.surveys.question;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
