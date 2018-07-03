package com.cafetamine.surveys.survey;

import com.cafetamine.surveys.user.User;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SurveyService {

    private SurveyRepository surveyRepository;

    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    private Survey getByIdAndAccessibleAndPublished(Long id, Boolean isAccessible, Boolean isPublished) {
        Optional<Survey> survey = this.surveyRepository.findByIdAndAccessibleAndPublished(id, isAccessible, isPublished);
        if (!survey.isPresent()) {
            // TODO exception
            throw new RuntimeException("404 survey not found");
        }
        return survey.get();
    }

    public Survey getPublishedById(Long id) {
        return this.getByIdAndAccessibleAndPublished(id, true, true);
    }

    public Survey getUnpublishedById(Long id) {
        return this.getByIdAndAccessibleAndPublished(id, true, false);
    }

    public Iterable<Survey> getPublished() {
        return this.surveyRepository.findAllByAccessibleAndPublished(true, true);
    }

    public Iterable<Survey> getUnpublished() {
        return this.surveyRepository.findAllByAccessibleAndPublished(true, false);
    }

    public Iterable<Survey> getByAuthor(User user) {
        return this.surveyRepository.findAllByAuthorAndAccessibleAndPublished(user, true, true);
    }

}
