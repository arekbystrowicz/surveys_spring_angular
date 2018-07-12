package com.cafetamine.surveys.answer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cafetamine.surveys.question.Question;


@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

    Iterable<Answer> findAllByQuestionAndIsAccessible(Question question, Boolean isAccessible);

}
