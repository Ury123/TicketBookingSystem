package com.innowise.ticketbookingsystem.repository;

import com.innowise.ticketbookingsystem.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    void save(User user);
}
