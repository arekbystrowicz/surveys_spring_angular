package com.cafetamine.surveys.solution;

import com.cafetamine.surveys.model.Solution;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.cafetamine.surveys.model.User;
import com.cafetamine.surveys.model.Answer;


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

    public Iterable<Solution> getAllByAnswerAndAuthor(Answer answer, User author) {
        return this.solutionRepository.findAllByAnswerAndAuthor(answer, author);
    }

    public Solution create(Solution solution) {
        // TODO adjust implementation to client
        return this.solutionRepository.save(solution);
    }

    public Solution update(Solution solution) {
        // TODO adjust implementation to client
        return this.solutionRepository.save(solution);
    }

    public Solution delete(Solution solution) {
        this.solutionRepository.delete(solution);
        return solution;
    }

}
