package com.cafetamine.surveys.category;

import org.springframework.stereotype.Service;

import java.util.Optional;

import com.cafetamine.surveys.user.User;


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
        this.categoryRepository.delete(category);
        
        return category;
    }

}
