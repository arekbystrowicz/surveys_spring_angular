package com.cafetamine.surveys.solution;

import org.springframework.stereotype.Service;

import java.util.Optional;

import com.cafetamine.surveys.answer.Answer;


@Service
public class SolutionService {

    private SolutionRepository solutionRepository;

    public SolutionService(SolutionRepository solutionRepository) {
        this.solutionRepository = solutionRepository;
    }

    public Solution getById(Long id) {
        Optional<Solution> solution = this.solutionRepository.findById(id);
        if (!solution.isPresent()) {
            // TODO exception
            throw new RuntimeException("404 solution not found");
        }
        return solution.get();
    }

    public Iterable<Solution> getByAnswer(Answer answer) {
        return this.solutionRepository.findAllByAnswer(answer);
    }

}
