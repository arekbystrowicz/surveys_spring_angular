package com.cafetamine.surveys.answer;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import com.cafetamine.surveys.question.Question;


@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

    Optional<Answer> findByIdAndIsAccessible(Long id, Boolean isAccessible);

    Iterable<Answer> findAllByQuestionAndIsAccessible(Question question, Boolean isAccessible);

}
