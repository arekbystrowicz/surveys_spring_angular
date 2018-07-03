package com.cafetamine.surveys.user;

import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getById(Long id) {
        Optional<User> user = this.userRepository.findByIdAndIsActive(id, true);
        if (!user.isPresent()) {
            // TODO exception
            throw new RuntimeException("404 user not found");
        }
        return user.get();
    }

}
