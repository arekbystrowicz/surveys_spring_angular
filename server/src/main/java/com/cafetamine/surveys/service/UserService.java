package com.cafetamine.surveys.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

import com.cafetamine.surveys.model.User;
import com.cafetamine.surveys.persistence.UserRepository;


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

    public Iterable<User> getAll() {
        return this.userRepository.findAllByIsActive(true);
    }

    public User create(User user) {
        // TODO adjust implementation to client
        user.setActive(true);
        return this.userRepository.save(user);
    }

    public User update(Long id, User updatedUser) {
        User user = this.getById(id);

        if (!updatedUser.getLogin().equals("")) {
            user.setLogin(updatedUser.getLogin());
        }
        if (!updatedUser.getEmail().equals("")) {
            user.setEmail(updatedUser.getEmail());
        }
        if (!updatedUser.getPassword().equals("")) {
            user.setPassword(updatedUser.getPassword());
        }
        if (!updatedUser.getName().equals("")) {
            user.setName(updatedUser.getName());
        }
        if (!updatedUser.getSurname().equals("")) {
            user.setSurname(updatedUser.getSurname());
        }

        return this.userRepository.save(user);
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
