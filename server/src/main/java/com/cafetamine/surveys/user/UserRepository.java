package com.cafetamine.surveys.user;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    Optional<User> findByIdAndIsActive(Long id, Boolean isActive);

}
