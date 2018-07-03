package com.cafetamine.surveys.survey;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long> {

    Optional<Survey> findByIdAndIsAccessibleAndIsPublished(Long id, Boolean isAccessible, Boolean isPublished);

    Iterable<Survey> findAllByIsAccessibleAndIsPublished(Boolean isAccessible, Boolean isPublished);

}
