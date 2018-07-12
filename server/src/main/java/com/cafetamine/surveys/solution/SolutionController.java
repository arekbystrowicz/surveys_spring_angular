package com.cafetamine.surveys.solution;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("solutions")
public class SolutionController {

    private SolutionService solutionService;

    public SolutionController(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @GetMapping("/{id}")
    public Solution getById(@PathVariable Long id) {
        return this.solutionService.getById(id);
    }

}
