package com.cafetamine.surveys.solution;

import org.springframework.web.bind.annotation.*;

import com.cafetamine.surveys.answer.AnswerService;


@RestController
@RequestMapping("solutions")
public class SolutionController {

    private SolutionService solutionService;
    private AnswerService answerService;

    public SolutionController(SolutionService solutionService, AnswerService answerService) {
        this.solutionService = solutionService;
        this.answerService = answerService;
    }

    @GetMapping("/{id}")
    public Solution getById(@PathVariable Long id) {
        return this.solutionService.getById(id);
    }

    @GetMapping(params = "answer_id={id}")
    public Iterable<Solution> getByAnswer(@RequestParam("answer_id") Long id) {
        return this.solutionService.getByAnswer(this.answerService.getById(id));
    }

    @PostMapping()
    public Solution create(@RequestBody Solution solution) {
        return this.solutionService.create(solution);
    }

    @PostMapping(value = "/{id}", params = "action=update")
    public Solution update(@RequestBody Solution solution) {
        return this.solutionService.update(solution);
    }

    @PostMapping(value = "/{id}", params = "action=delete") 
    public Solution delete(@PathVariable Long id) {
        return this.solutionService.delete(this.solutionService.getById(id));
    }

}
