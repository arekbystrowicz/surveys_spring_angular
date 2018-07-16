package com.cafetamine.surveys.controller;

import org.springframework.web.bind.annotation.*;

import com.cafetamine.surveys.model.Answer;
import com.cafetamine.surveys.service.AnswerService;
import com.cafetamine.surveys.service.QuestionService;


@RestController
@RequestMapping("questions/{question_id}/answers")
public class AnswerController {

    private AnswerService answerService;


    public AnswerController(AnswerService answerService, QuestionService questionService) {
        this.answerService = answerService;
    }

    // TODO dev only
    @GetMapping()
    public Iterable<Answer> getAll(@PathVariable("question_id") Long questionId) {
        return this.answerService.getAll();
    }

    @GetMapping("/{id}")
    public Answer getById(@PathVariable Long id) {
        return this.answerService.getById(id);
    }

      // TODO not working (issue::path root and parameters)
      // TODO through probably not needed as access is provided through question
//    @GetMapping(params = "question_id={id}")
//    public Iterable<Answer> getByQuestion(@RequestParam("question_id") Long id) {
//        return this.answerService.getByQuestion(this.questionService.getById(id));
//    }

    @PostMapping()
    public Answer create(@RequestBody Answer answer) {
        return this.answerService.create(answer);
    }

    @PostMapping(value = "/{id}", params = "action=update")
    public Answer update(@RequestBody Answer answer) {
        return this.answerService.update(answer);
    }

    @PostMapping(value = "/{id}", params = "action=delete")
    public Answer delete(@PathVariable Long id) {
        return this.answerService.delete(id);
    }

}
