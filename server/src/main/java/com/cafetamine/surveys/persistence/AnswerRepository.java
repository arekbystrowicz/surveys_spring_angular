package com.cafetamine.surveys.persistence;

import com.cafetamine.surveys.model.Answer;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import com.cafetamine.surveys.model.Question;


@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

    Optional<Answer> findByIdAndIsAccessible(Long id, Boolean isAccessible);

    // TODO dev only
    Iterable<Answer> findAllByIsAccessible(Boolean isAccessible);

    Iterable<Answer> findAllByQuestionAndIsAccessible(Question question, Boolean isAccessible);

}
