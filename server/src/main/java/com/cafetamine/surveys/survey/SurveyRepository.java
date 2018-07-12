package com.cafetamine.surveys.survey;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import com.cafetamine.surveys.user.User;
import com.cafetamine.surveys.category.Category;


@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long> {

    Optional<Survey> findByIdAndIsAccessibleAndIsPublished(Long id, Boolean isAccessible, Boolean isPublished);

    Optional<Survey> findByIdAndIsAccessible(Long id, Boolean isAccessible);

    Iterable<Survey> findAllByIsAccessibleAndIsPublished(Boolean isAccessible, Boolean isPublished);

    Iterable<Survey> findAllByAuthorAndIsAccessibleAndIsPublished(User author, Boolean isAccessible, Boolean isPublished);

    Iterable<Survey> findAllByCategoriesContainingAndIsAccessibleAndIsPublished(Category category, Boolean isAccessible, Boolean isPublished);

    Iterable<Survey> findAllByTitleAndIsAccessibleAndIsPublished(String title, Boolean isAccessible, Boolean isPublished);

}
