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

    private Survey getByIdAndAccessibleAndPublished(Long id, Boolean isAccessible, Boolean isPublished) {
        Optional<Survey> survey = this.surveyRepository.findByIdAndIsAccessibleAndPublished(id, isAccessible, isPublished);
        if (!survey.isPresent()) {
            // TODO exception
            throw new RuntimeException("404 survey not found");
        }
        return survey.get();
    }

    public Survey getPublishedById(Long id) {
        return this.getByIdAndAccessibleAndPublished(id, true, true);
    }

    public Survey getUnpublishedById(Long id) {
        return this.getByIdAndAccessibleAndPublished(id, true, false);
    }

    public Iterable<Survey> getPublished() {
        return this.surveyRepository.findAllByIsAccessibleAndPublished(true, true);
    }

    public Iterable<Survey> getUnpublished() {
        return this.surveyRepository.findAllByIsAccessibleAndPublished(true, false);
    }

    public Iterable<Survey> getByAuthor(User user) {
        return this.surveyRepository.findAllByAuthorAndIsAccessibleAndPublished(user, true, true);
    }

    public Iterable<Survey> getWorkspace(User user) {
        return this.surveyRepository.findAllByAuthorAndIsAccessibleAndPublished(user, true, false);
    }

    public Iterable<Survey> getByCategory(Category category) {
        return this.surveyRepository.findAllByCategoriesContainingIsAndAccessibleAndPublished(category, true, true);
    }

    public Iterable<Survey> getByTitle(String title) {
        return this.surveyRepository.findAllByTitleAndIsAccessibleAndPublished(title, true, true);
    }

    public Survey create(Survey survey) {
        // TODO adjust implementation to client
        return this.surveyRepository.save(survey);
    }

    public Survey update(Survey survey) {
        // TODO adjust implementation to client
        return this.surveyRepository.save(survey);
    }

    public Survey delete(Survey survey) {
        survey.setAccessible(false);
        return this.surveyRepository.save(survey);
    }

    public void deleteAllByAuthor(User author) {
        for (Survey survey : this.getByAuthor(author)) {
            this.delete(survey);
        }
    }

}
