package com.cafetamine.surveys.survey;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import com.cafetamine.surveys.user.User;
import com.cafetamine.surveys.category.Category;


@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long> {

    Optional<Survey> findByIdAndIsAccessibleAndPublished(Long id, Boolean isAccessible, Boolean isPublished);

    Iterable<Survey> findAllByIsAccessibleAndPublished(Boolean isAccessible, Boolean isPublished);

    Iterable<Survey> findAllByAuthorAndIsAccessibleAndPublished(User author, Boolean isAccessible, Boolean isPublished);

    Iterable<Survey> findAllByCategoriesContainingIsAndAccessibleAndPublished(Category category, Boolean isAccessible, Boolean isPublished);

    Iterable<Survey> findAllByTitleAndIsAccessibleAndPublished(String title, Boolean isAccessible, Boolean isPublished);

}
