package com.cafetamine.surveys.question;

import com.cafetamine.surveys.model.Question;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import com.cafetamine.surveys.model.Survey;


@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

    Optional<Question> findByIdAndIsAccessible(Long id, Boolean isAccessible);

    // TODO dev only
    Iterable<Question> findAllByIsAccessible(Boolean isAccessible);

    Iterable<Question> findAllBySurveyAndIsAccessible(Survey survey, Boolean isAccessible);

}
