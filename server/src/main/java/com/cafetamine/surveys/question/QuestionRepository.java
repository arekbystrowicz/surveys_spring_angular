package com.cafetamine.surveys.question;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

    Optional<Question> findByIdAndIsAccessible(Long id, Boolean isAccessible);

    // TODO dev only
    Iterable<Question> findAllByIsAccessible(Boolean isAccessible);

    Iterable<Question> findAllBySurveyIdAndIsAccessible(Long surveyId, Boolean isAccessible);

}
