package com.cafetamine.surveys.user;

import org.springframework.stereotype.Service;


@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
}
