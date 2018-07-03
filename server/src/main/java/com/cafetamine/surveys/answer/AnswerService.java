package com.cafetamine.surveys.answer;

import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AnswerService {

    private AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer getById(Long id) {
        Optional<Answer> answer = this.answerRepository.findById(id);
        if (!answer.isPresent()) {
            // TODO exception
            throw new RuntimeException("404 question not found");
        }
        return answer.get();
    }

}
