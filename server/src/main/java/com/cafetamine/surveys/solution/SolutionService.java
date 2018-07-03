package com.cafetamine.surveys.solution;

import org.springframework.stereotype.Service;


@Service
public class SolutionService {

    private SolutionRepository solutionRepository;

    public SolutionService(SolutionRepository solutionRepository) {
        this.solutionRepository = solutionRepository;
    }

}
