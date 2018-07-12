package com.cafetamine.surveys.survey;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("surveys")
public class SurveyController {

    private SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping(value = "/{id}", params="show=published")
    public Survey getPublishedById(@PathVariable Long id) {
        return this.surveyService.getPublishedById(id);
    }

    @GetMapping(value = "/{id}", params="show=workspace")
    public Survey getWorkspaceById(@PathVariable Long id) {
        return this.surveyService.getUnpublishedById(id);
    }

}
