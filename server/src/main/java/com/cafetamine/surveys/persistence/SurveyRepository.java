package com.cafetamine.surveys.persistence;

import com.cafetamine.surveys.model.Survey;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import com.cafetamine.surveys.model.User;
import com.cafetamine.surveys.model.Category;


@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long> {

    Optional<Survey> findByIdAndIsAccessible(Long id, Boolean isAccessible);

    Iterable<Survey> findAllByIsAccessible(Boolean isPublished);

    Iterable<Survey> findAllByAuthorAndIsAccessible(User author, Boolean isAccessible);

    Iterable<Survey> findAllByCategoriesContainingAndIsAccessible(Category category, Boolean isAccessible);

    Iterable<Survey> findAllByTitleAndIsAccessible(String title, Boolean isAccessible);

}
