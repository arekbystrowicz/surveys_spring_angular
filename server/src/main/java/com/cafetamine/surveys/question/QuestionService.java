package com.cafetamine.surveys.question;

import org.springframework.stereotype.Service;


@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

}

