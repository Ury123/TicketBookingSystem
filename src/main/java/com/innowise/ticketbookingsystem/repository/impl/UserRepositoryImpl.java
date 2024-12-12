package com.innowise.ticketbookingsystem.repository.impl;

import com.innowise.ticketbookingsystem.model.User;
import com.innowise.ticketbookingsystem.repository.UserRepository;
import com.innowise.ticketbookingsystem.utils.JpaUtils;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public Optional<User> findByUsername(String username) {
        try (EntityManager em = JpaUtils.getEntityManager()) {
            return em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getResultStream()
                    .findFirst();
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (EntityManager em = JpaUtils.getEntityManager()) {
            return em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                    .setParameter("email", email)
                    .getResultStream()
                    .findFirst();
        }
    }

    @Override
    public void save(User user) {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
