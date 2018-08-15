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

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id) {
        return this.categoryService.getById(id);
    }

    @PostMapping()
    public Category create(@RequestBody Category category) {
        return this.categoryService.create(category);
    }

    @PutMapping(value = "/{id}")
    public Category update(@RequestBody Category category, @PathVariable("id") Long id) {
        return this.categoryService.update(id, category);
    }

    @DeleteMapping(value = "/{id}")
    public Category delete(@PathVariable Long id) {
        return this.categoryService.delete(id);
    }

}
