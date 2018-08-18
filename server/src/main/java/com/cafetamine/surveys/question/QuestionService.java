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

    // TODO development only
    public Iterable<Question> getAll() {
        return this.questionRepository.findAllByIsAccessible(true);
    }

    public Iterable<Question> getAllBySurveyId(Long surveyId) {
        return this.questionRepository.findAllBySurveyIdAndIsAccessible(surveyId, true);
    }

    public Question create(Survey survey, Question question) {
        question.setSurvey(survey);
        question.setAccessible(true);

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
        question.setAccessible(false);

        return this.questionRepository.save(question);
    }

}

