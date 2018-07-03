package com.cafetamine.surveys.user;

import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private User getByIdAndActive(Long id, Boolean isActive) {
        Optional<User> user = this.userRepository.findByIdAndIsActive(id, isActive);
        if (!user.isPresent()) {
            // TODO exception
            throw new RuntimeException("404 user not found");
        }
        return user.get();
    }

    public User getById(Long id) {
        return this.getByIdAndActive(id, true);
    }

    public User delete(Long id) {
        User user = this.getById(id);
        user.setActive(false);
        
        return this.userRepository.save(user);
    }

    public User restore(Long id) {
        User user = this.getByIdAndActive(id, false);
        user.setActive(true);

        return this.userRepository.save(user);
    }

}
