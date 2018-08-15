package com.cafetamine.surveys.category;

import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public Iterable<Category> getAll() {
        return this.categoryService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Category getById(@PathVariable("id") Long id) {
        return this.categoryService.getById(id);
    }

    @PostMapping()
    public Category getByTag(@RequestBody Category category) {
        return this.categoryService.forTag(category);
    }

}
