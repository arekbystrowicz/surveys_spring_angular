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

    public Category getById(Long id) {
        Optional<Category> category = this.categoryRepository.findById(id);
        if (!category.isPresent()) {
            throw new RuntimeException("404 category not found");
        }
        return category.get();
    }

    public Category forTag(Category category) {
        Optional<Category> fromTag = this.categoryRepository.findByTag(category.getTag());
        if (fromTag.isPresent()) {
            return fromTag.get();
        }
        return this.create(category);
    }

    public Category delete(Long id) {
        Category category = this.getById(id);
        this.categoryRepository.delete(category);

        return category;
    }

    private Category create(Category category) {
        return this.categoryRepository.save(category);
    }

}
