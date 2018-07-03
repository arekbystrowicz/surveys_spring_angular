package com.cafetamine.surveys.category;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
