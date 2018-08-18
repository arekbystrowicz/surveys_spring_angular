package com.cafetamine.surveys.answer;

import org.springframework.web.bind.annotation.*;

import com.cafetamine.surveys.question.QuestionService;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("questions/{question_id}/answers")
public class AnswerController {

    private AnswerService answerService;
    private QuestionService questionService;

    public AnswerController(AnswerService answerService, QuestionService questionService) {
        this.answerService = answerService;
        this.questionService = questionService;
    }

    @GetMapping()
    public Iterable<Answer> getAll(@PathVariable("question_id") Long questionId) {
        return this.answerService.getByQuestion(this.questionService.getById(questionId));
    }

    @GetMapping("/{answer_id}")
    public Answer getById(@PathVariable("answer_id") Long id) {
        return this.answerService.getById(id);
    }

    @PostMapping()
    public Answer create(@PathVariable("question_id") Long questionId, @RequestBody Answer answer) {
        return this.answerService.create(answer, this.questionService.getById(questionId));
    }

    @PutMapping(value = "/{answer_id}")
    public Answer update(@RequestBody Answer answer, @PathVariable("answer_id") Long id) {
        return this.answerService.update(id, answer);
    }

    @DeleteMapping(value = "/{answer_id}")
    public Answer delete(@PathVariable("answer_id") Long id) {
        return this.answerService.delete(id);
    }

}
