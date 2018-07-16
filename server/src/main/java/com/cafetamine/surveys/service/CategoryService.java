package com.cafetamine.surveys.service;

import com.cafetamine.surveys.model.Category;
import com.cafetamine.surveys.persistence.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.cafetamine.surveys.model.User;
import com.cafetamine.surveys.model.Survey;


@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private SurveyService surveyService;

    public CategoryService(CategoryRepository categoryRepository, SurveyService surveyService) {
        this.categoryRepository = categoryRepository;
        this.surveyService = surveyService;
    }

    public Category getById(Long id) {
        Optional<Category> category = this.categoryRepository.findById(id);
        if (!category.isPresent()) {
            // TODO exception
            throw new RuntimeException("404 category not found");
        }
        return category.get();
    }

    public Category getByTag(String tag) {
        Optional<Category> category = this.categoryRepository.findByTag(tag);
        if (!category.isPresent()) {
            // TODO exception
            throw new RuntimeException("404 category not found");
        }
        return category.get();
    }

    public Iterable<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    public Iterable<Category> getByAuthor(User author) {
        return this.categoryRepository.findAllByAuthor(author);
    }

    public Category create(Category category) {
        // TODO adjust implementation to client
        return this.categoryRepository.save(category);
    }

    public Category update(Category category) {
        // TODO adjust implementation to client
        return this.categoryRepository.save(category);
    }

    public Category delete(Long id) {
        // TODO adjust implementation to client
        Category category = this.getById(id);
        // TODO tragic! get it out (check this.isUsed)
        if (this.isUsed(category)) {
            throw new RuntimeException("This category is used, and cannot be deleted");
        }
        this.categoryRepository.delete(category);

        return category;
    }

    // TODO change Iterables to sth normal
    // TODO then get rid of this shitty method
    private Boolean isUsed(Category category) {
        for (Survey survey : surveyService.getByCategory(category)) {
            return true;
        }
        return false;
    }

}
