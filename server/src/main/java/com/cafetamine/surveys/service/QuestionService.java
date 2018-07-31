package com.cafetamine.surveys.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

import com.cafetamine.surveys.model.Survey;
import com.cafetamine.surveys.model.Question;
import com.cafetamine.surveys.persistence.QuestionRepository;


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

    // TODO development only
    public Iterable<Question> getAll() {
        return this.questionRepository.findAllByIsAccessible(true);
    }

    public Iterable<Question> getAllBySurvey(Survey survey) {
        return this.questionRepository.findAllBySurveyAndIsAccessible(survey, true);
    }

    public Question create(Question question) {
        // TODO adjust implementation to client
        return this.questionRepository.save(question);
    }

    public Question update(Long id, Question updatedQuestion) {
        Question question = this.getById(id);

        String title = updatedQuestion.getTitle();
        String description = updatedQuestion.getDescription();

        if (!title.equals("")) {
            question.setTitle(title);
        }
        if (!description.equals("")) {
            question.setDescription(description);
        }

        return this.questionRepository.save(question);
    }

    public Question delete(Question question) {
        // TODO adjust implementation to client
        question.setAccessible(false);
        return this.questionRepository.save(question);
    }

}

