package com.cafetamine.surveys.controller;

import org.springframework.web.bind.annotation.*;

import com.cafetamine.surveys.model.Category;
import com.cafetamine.surveys.service.CategoryService;


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

      // TODO parameters on source root?
//    @GetMapping(params = "user_id={id}")
//    public Iterable<Category> getAllByAuthor(@RequestParam("user_id") Long id) {
//        return this.categoryService.getByAuthor(this.userService.getById(id));
//    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id) {
        return this.categoryService.getById(id);
    }

    @PostMapping()
    public Category create(@RequestBody Category category) {
        return this.categoryService.create(category);
    }

    // TODO check UserController's update comments
    @PostMapping(value = "/{id}", params = "action=update")
    public Category update(@RequestBody Category category) {
        return this.categoryService.update(category);
    }

    // TODO cannot be performed! check for safety
    @PostMapping(value = "/{id}", params = "action=delete")
    public Category delete(@PathVariable Long id) {
        return this.categoryService.delete(id);
    }

}
