package com.cafetamine.surveys.survey;

import org.springframework.stereotype.Service;

import java.util.Optional;

import com.cafetamine.surveys.user.User;
import com.cafetamine.surveys.category.Category;

import com.cafetamine.surveys.category.CategoryService;


@Service
public class SurveyService {

    private SurveyRepository surveyRepository;
    private CategoryService categoryService;

    public SurveyService(SurveyRepository surveyRepository, CategoryService categoryService) {
        this.surveyRepository = surveyRepository;
        this.categoryService = categoryService;
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

    public Survey update(Long id, Survey updatedSurvey) {
        Survey survey = this.getById(id);

        String title = updatedSurvey.getTitle();
        String description = updatedSurvey.getDescription();

        if (!title.equals("")) {
            survey.setTitle(title);
        }
        if (!description.equals("")) {
            survey.setDescription(description);
        }

        return this.surveyRepository.save(survey);
    }

    public Survey delete(Long id) {
        Survey survey = this.getById(id);
        survey.setAccessible(false);

        return this.surveyRepository.save(survey);
    }

    public Survey addCategory(Long surveyId, Long categoryId) {
        Survey survey = this.getById(surveyId);
        survey.getCategories().add(this.categoryService.getById(categoryId));

        return this.surveyRepository.save(survey);
    }

    public Survey removeCategory(Long surveyId, Long categoryId) {
        Survey survey = this.getById(surveyId);
        Category category = this.categoryService.getById(categoryId);

        survey.getCategories().remove(category);
        survey = this.surveyRepository.save(survey);

        return survey;
    }

}
