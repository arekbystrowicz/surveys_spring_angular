package com.cafetamine.surveys.survey;

import org.springframework.stereotype.Service;

import java.util.Optional;

import com.cafetamine.surveys.user.User;
import com.cafetamine.surveys.category.Category;


@Service
public class SurveyService {

    private SurveyRepository surveyRepository;

    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public Survey getById(Long id) {
        Optional<Survey> survey = this.surveyRepository.findByIdAndIsAccessible(id, true);
        if (!survey.isPresent()) {
            // TODO exception
            throw new RuntimeException("404 survey not found");
        }
        return survey.get();
    }

    public Iterable<Survey> getAll() {
        return this.surveyRepository.findAllByIsAccessible(true);
    }

    public Iterable<Survey> getByAuthor(User user) {
        return this.surveyRepository.findAllByAuthorAndIsAccessible(user, true);
    }

    public Iterable<Survey> getByCategory(Category category) {
        return this.surveyRepository.findAllByCategoriesContainingAndIsAccessible(category, true);
    }

    public Iterable<Survey> getByTitle(String title) {
        return this.surveyRepository.findAllByTitleAndIsAccessible(title, true);
    }

    public Survey create(Survey survey) {
        // TODO adjust implementation to client
        return this.surveyRepository.save(survey);
    }

    public Survey update(Survey survey) {
        // TODO adjust implementation to client
        return this.surveyRepository.save(survey);
    }

    public Survey delete(Long id) {
        Survey survey = this.getById(id);
        survey.setAccessible(false);

        return this.surveyRepository.save(survey);
    }

    public void deleteAllByAuthor(User author) {
        for (Survey survey : this.getByAuthor(author)) {
            this.delete(survey);
        }
    }

}
