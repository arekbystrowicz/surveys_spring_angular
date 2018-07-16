package com.cafetamine.surveys.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import com.cafetamine.surveys.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByIdAndIsActive(Long id, Boolean isActive);

    Iterable<User> findAllByIsActive(Boolean isActive);

}
