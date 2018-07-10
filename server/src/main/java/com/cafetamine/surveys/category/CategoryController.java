package com.cafetamine.surveys.category;

import com.cafetamine.surveys.user.UserService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;
    private UserService userService;

    public CategoryController(CategoryService categoryService, UserService userService) {
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping(params = "action=show_all")
    public Iterable<Category> getAll() {
        return this.categoryService.getAll();
    }

    @GetMapping(params = "user_id={id}")
    public Iterable<Category> getAllByAuthor(@RequestParam Long id) {
        return this.categoryService.getByAuthor(this.userService.getById(id));
    }

    @GetMapping("/{id}")
    public Category getById(@RequestParam Long id) {
        return this.categoryService.getById(id);
    }

}
