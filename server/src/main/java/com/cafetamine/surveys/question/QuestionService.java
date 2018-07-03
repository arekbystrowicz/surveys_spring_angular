package com.cafetamine.surveys.question;

import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question getById(Long id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if (!question.isPresent()) {
            // TODO exception
            throw new RuntimeException("404 question not found");
        }
        return question.get();
    }

}

