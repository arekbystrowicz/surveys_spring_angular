package com.cafetamine.surveys.answer;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cafetamine.surveys.question.QuestionService;


@RestController
@RequestMapping("answers")
public class AnswerController {

    private AnswerService answerService;
    private QuestionService questionService;

    public AnswerController(AnswerService answerService, QuestionService questionService) {
        this.answerService = answerService;
        this.questionService = questionService;
    }

    @GetMapping("/{id}")
    public Answer getById(@PathVariable Long id) {
        return this.answerService.getById(id);
    }

}
