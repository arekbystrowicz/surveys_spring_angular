package com.cafetamine.surveys.answer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("answers")
public class AnswerController {

    private AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @RequestMapping("/{id}")
    public Answer getById(@PathVariable Long id) {
        return this.answerService.getById(id);
    }

}
