package com.cafetamine.surveys.survey;

import org.springframework.web.bind.annotation.*;

import com.cafetamine.surveys.category.Category;

import com.cafetamine.surveys.user.UserService;
import com.cafetamine.surveys.category.CategoryService;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("surveys")
public class SurveyController {

    private SurveyService surveyService;
    private UserService userService;
    private CategoryService categoryService;

    public SurveyController(SurveyService surveyService,
                            UserService userService,
                            CategoryService categoryService) {

        this.surveyService = surveyService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @GetMapping()
    public Iterable<Survey> getAll() {
        return this.surveyService.getAll();
    }

    @GetMapping("/{id}")
    public Survey getById(@PathVariable Long id) {
        return this.surveyService.getById(id);
    }

    @GetMapping(params = "user_id={id}")
    public Iterable<Survey> getByAuthor(@RequestParam Long id) {
        return this.surveyService.getByAuthor(this.userService.getById(id));
    }

    @PostMapping()
    public Survey create(@RequestBody Survey survey) {
        return this.surveyService.create(survey);
    }

    @PutMapping(value = "/{id}")
    public Survey update(@RequestBody Survey survey, @PathVariable("id") Long id) {
        return this.surveyService.update(id, survey);
    }

    @DeleteMapping(value = "/{id}")
    public Survey delete(@PathVariable Long id) {
        return this.surveyService.delete(id);
    }

    @PutMapping(value = "/{survey_id}/categories/{category_id}")
    public Survey addCategory(@PathVariable("survey_id") Long surveyId,
                              @PathVariable("category_id") Long categoryId) {

        return this.surveyService.addCategory(surveyId, this.categoryService.getById(categoryId));
    }

    @DeleteMapping(value = "/{survey_id}/categories/{category_id}")
    public Survey removeCategory(@PathVariable("survey_id") Long surveyId,
                                 @PathVariable("category_id") Long categoryId) {

        return this.surveyService.removeCategory(surveyId, this.categoryService.getById(categoryId));
    }

}
