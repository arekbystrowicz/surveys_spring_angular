package com.cafetamine.surveys.category;

import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
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

}
