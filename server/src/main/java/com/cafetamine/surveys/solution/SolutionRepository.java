package com.cafetamine.surveys.solution;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.cafetamine.surveys.answer.Answer;


@Repository
public interface SolutionRepository extends CrudRepository<Solution, Long> {

    Iterable<Solution> findAllByAnswer(Answer answer);

}
