package com.cafetamine.surveys.survey;

import org.springframework.web.bind.annotation.*;

import com.cafetamine.surveys.user.UserService;


@RestController
@RequestMapping("surveys")
public class SurveyController {

    private SurveyService surveyService;
    private UserService userService;

    public SurveyController(SurveyService surveyService, UserService userService) {
        this.surveyService = surveyService;
        this.userService = userService;
    }

    @GetMapping(value = "/{id}", params="show=published")
    public Survey getPublishedById(@PathVariable Long id) {
        return this.surveyService.getPublishedById(id);
    }

    @GetMapping(value = "/{id}", params="show=workspace")
    public Survey getWorkspaceById(@PathVariable Long id) {
        return this.surveyService.getUnpublishedById(id);
    }

    @GetMapping(params = "show=published")
    public Iterable<Survey> getAllPublished() {
        return this.surveyService.getPublished();
    }

}
