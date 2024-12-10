package com.innowise.ticketbookingsystem.repository.impl;

import com.innowise.ticketbookingsystem.model.Movie;
import com.innowise.ticketbookingsystem.repository.MovieRepository;
import com.innowise.ticketbookingsystem.utils.JpaUtils;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MovieRepositoryImpl implements MovieRepository {


    @Override
    public void save(Movie movie) {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(movie);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Movie movie) {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(movie);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<Movie> findById(UUID id) {
        try (EntityManager em = JpaUtils.getEntityManager()) {
            return Optional.ofNullable(em.find(Movie.class, id));
        }
    }

    @Override
    public void deleteById(UUID id) {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            em.getTransaction().begin();
            Movie movie = em.find(Movie.class, id);
            em.remove(movie);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Movie> findAll() {
        try (EntityManager em = JpaUtils.getEntityManager()) {
            return em.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
        }
    }

    @Override
    public List<Movie> findByTitle(String title) {
        try (EntityManager em = JpaUtils.getEntityManager()) {
            return em.createQuery("SELECT m FROM Movie m WHERE m.title = :title", Movie.class)
                    .setParameter("title", title)
                    .getResultList();
        }
    }
}
