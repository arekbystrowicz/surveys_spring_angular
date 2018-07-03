package com.cafetamine.surveys.answer;

import org.springframework.stereotype.Service;


@Service
public class AnswerService {

    private AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

}
