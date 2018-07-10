package com.cafetamine.surveys.category;

import com.cafetamine.surveys.user.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;
    private UserService userService;

    public CategoryController(CategoryService categoryService, UserService userService) {
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping()
    public Iterable<Category> getAll() {
        return this.categoryService.getAll();
    }

    @GetMapping(params = "user_id={id}")
    public Iterable<Category> getAllByAuthor(@RequestParam("user_id") Long id) {
        return this.categoryService.getByAuthor(this.userService.getById(id));
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id) {
        return this.categoryService.getById(id);
    }

    @PostMapping()
    public Category create(@RequestBody Category category) {
        return this.categoryService.create(category);
    }

    @PostMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category) {
        return this.categoryService.update(category);
    }

}
