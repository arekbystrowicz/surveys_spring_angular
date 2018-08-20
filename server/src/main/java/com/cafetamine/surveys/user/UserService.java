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

    public Iterable<User> getAll() {
        return this.userRepository.findAllByIsActive(true);
    }

    public User getByLogin(String login) {
        return this.userRepository.findOneByLogin(login).get();
    }

    public User getByEmail(String email) {
        return this.userRepository.findOneByEmail(email).get();
    }

    public User create(User user) {
        user.setActive(true);
        return this.userRepository.save(user);
    }

    public User update(Long id, User updatedUser) {
        User user = this.getById(id);

        String login = updatedUser.getLogin();
        String email = updatedUser.getEmail();
        String password = updatedUser.getPassword();
        String name = updatedUser.getName();
        String surname = updatedUser.getSurname();

        if (!login.equals("")) {
            user.setLogin(login);
        }
        if (!email.equals("")) {
            user.setEmail(email);
        }
        if (!password.equals("")) {
            user.setPassword(password);
        }
        if (!name.equals("")) {
            user.setName(name);
        }
        if (!surname.equals("")) {
            user.setSurname(surname);
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
