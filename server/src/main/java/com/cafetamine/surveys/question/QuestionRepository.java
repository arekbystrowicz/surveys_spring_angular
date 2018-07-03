package com.cafetamine.surveys.question;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
}
