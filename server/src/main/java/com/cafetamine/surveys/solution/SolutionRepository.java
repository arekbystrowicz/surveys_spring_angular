package com.cafetamine.surveys.solution;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface SolutionRepository extends CrudRepository<Solution, Long> {
}
