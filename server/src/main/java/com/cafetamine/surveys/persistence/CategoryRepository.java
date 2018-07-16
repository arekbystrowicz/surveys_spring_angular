package com.cafetamine.surveys.persistence;

import com.cafetamine.surveys.model.Category;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import com.cafetamine.surveys.model.User;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByTag(String tag);

    Iterable<Category> findAllByAuthor(User author);

}
