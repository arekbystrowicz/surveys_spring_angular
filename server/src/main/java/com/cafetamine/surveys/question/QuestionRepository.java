package com.cafetamine.surveys.question;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import com.cafetamine.surveys.survey.Survey;


@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

    Optional<Question> findByIdAndAccessible(Long id, Boolean isAccessible);

    Iterable<Question> findAllBySurveyAndAccessible(Survey survey, Boolean isAccessible);

}
