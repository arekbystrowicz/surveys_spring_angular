package com.cafetamine.surveys.category;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import com.cafetamine.surveys.user.User;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByTag(String tag);

    Iterable<Category> findByAuthor(User author);

}
