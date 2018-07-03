package com.cafetamine.surveys.category;

import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
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
