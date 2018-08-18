package com.cafetamine.surveys.question;

import org.springframework.web.bind.annotation.*;

import com.cafetamine.surveys.survey.SurveyService;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("surveys/{survey_id}/questions")
public class QuestionController {

    private QuestionService questionService;
    private SurveyService surveyService;

    public QuestionController(QuestionService questionService, SurveyService surveyService) {
        this.questionService = questionService;
        this.surveyService = surveyService;
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
        return this.questionService.create(this.surveyService.getById(surveyId), question);
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
