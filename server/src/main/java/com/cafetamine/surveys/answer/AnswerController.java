package com.cafetamine.surveys.answer;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping(params = "question_id={id}")
    public Iterable<Answer> getByQuestion(@RequestParam("question_id") Long id) {
        return this.answerService.getByQuestion(this.questionService.getById(id));
    }

}
