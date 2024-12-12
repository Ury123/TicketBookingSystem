package com.innowise.ticketbookingsystem.service;

import com.innowise.ticketbookingsystem.model.User;
import com.innowise.ticketbookingsystem.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Optional;

public class UserService {
    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public Optional<User> getUserByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }

    public boolean registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()
                || userRepository.findByEmail(user.getEmail()).isPresent()) {
            return false;
        }
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userRepository.save(user);
        return true;
    }

    public boolean validateUser(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return BCrypt.checkpw(password, user.getPassword());
        }
        return false;
    }
}
