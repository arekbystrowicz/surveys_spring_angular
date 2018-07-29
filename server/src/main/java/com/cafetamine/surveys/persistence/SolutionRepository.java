package com.cafetamine.surveys.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.cafetamine.surveys.model.User;
import com.cafetamine.surveys.model.Answer;
import com.cafetamine.surveys.model.Solution;


@Repository
public interface SolutionRepository extends CrudRepository<Solution, Long> {

    Iterable<Solution> findAllByAnswer(Answer answer);

    Iterable<Solution> findAllByAnswerAndAuthor(Answer answer, User author);

}
