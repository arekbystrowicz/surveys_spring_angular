package com.cafetamine.surveys.survey;

import org.springframework.web.bind.annotation.*;

import com.cafetamine.surveys.user.UserService;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("surveys")
public class SurveyController {

    private SurveyService surveyService;
    private UserService userService;

    public SurveyController(SurveyService surveyService, UserService userService) {
        this.surveyService = surveyService;
        this.userService = userService;
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

    @PostMapping(params = "user_id")
    public Survey create(@RequestBody Survey survey, @RequestParam("user_id") Long userId) {
        return this.surveyService.create(survey, this.userService.getById(userId));
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

        return this.surveyService.addCategory(surveyId, categoryId);
    }

    @DeleteMapping(value = "/{survey_id}/categories/{category_id}")
    public Survey removeCategory(@PathVariable("survey_id") Long surveyId,
                                 @PathVariable("category_id") Long categoryId) {

        return this.surveyService.removeCategory(surveyId, categoryId);
    }

}
