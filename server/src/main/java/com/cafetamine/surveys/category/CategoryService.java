package com.cafetamine.surveys.category;

import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Iterable<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    public Category forTag(Category category) {
        Optional<Category> fromTag = this.categoryRepository.findByTag(category.getTag());
        if (fromTag.isPresent()) {
            return fromTag.get();
        }
        return this.create(category);
    }
}
