package com.cafetamine.surveys.survey;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.cafetamine.surveys.user.User;


@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long> {

    Optional<Survey> findByIdAndAccessibleAndPublished(Long id, Boolean isAccessible, Boolean isPublished);

    Iterable<Survey> findAllByAccessibleAndPublished(Boolean isAccessible, Boolean isPublished);

    Iterable<Survey> findAllByAuthorAndAccessibleAndPublished(User author, Boolean isAccessible, Boolean isPublished);

}
