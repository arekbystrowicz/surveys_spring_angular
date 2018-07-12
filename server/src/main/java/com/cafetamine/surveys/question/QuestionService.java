package com.cafetamine.surveys.question;

import org.springframework.stereotype.Service;

import java.util.Optional;

import com.cafetamine.surveys.survey.Survey;


@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question getById(Long id) {
        Optional<Question> question = this.questionRepository.findByIdAndIsAccessible(id, true);
        if (!question.isPresent()) {
            // TODO exception
            throw new RuntimeException("404 question not found");
        }
        return question.get();
    }

    public Iterable<Question> getAllBySurvey(Survey survey) {
        return this.questionRepository.findAllBySurveyAndIsAccessible(survey, true);
    }

    public Question create(Question question) {
        // TODO adjust implementation to client
        return this.questionRepository.save(question);
    }

    public Question update(Question question) {
        // TODO adjust implementation to client
        return this.questionRepository.save(question);
    }

    public Question delete(Question question) {
        // TODO adjust implementation to client
        question.setAccessible(false);
        return this.questionRepository.save(question);
    }

}

