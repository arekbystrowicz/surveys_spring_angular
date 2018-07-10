package com.cafetamine.surveys.category;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public Iterable<Category> categories() {
        return this.categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getById(@RequestParam Long id) {
        return this.categoryService.getById(id);
    }

}
