package com.innowise.ticketbookingsystem.repository.impl;

import com.innowise.ticketbookingsystem.model.Session;
import com.innowise.ticketbookingsystem.repository.SessionRepository;
import com.innowise.ticketbookingsystem.utils.JpaUtils;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SessionRepositoryImpl implements SessionRepository {

    @Override
    public void save(Session session) {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(session);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Session session) {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(session);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<Session> findById(UUID id) {
        try (EntityManager em = JpaUtils.getEntityManager()) {
            return Optional.ofNullable(em.find(Session.class, id));
        }
    }

    @Override
    public void deleteById(UUID id) {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.find(Session.class, id));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Session> findAll() {
        try (EntityManager em = JpaUtils.getEntityManager()) {
            return em.createQuery("select s from Session s", Session.class).getResultList();
        }
    }

    @Override
    public List<Session> findByDate(LocalDate date) {
        try (EntityManager em = JpaUtils.getEntityManager()) {
            return em.createQuery("SELECT s FROM Session s WHERE DATE(s.startDateTime) = :date",
                            Session.class)
                    .getResultList();
        }
    }

    @Override
    public List<Session> findFromToday() {
        try (EntityManager em = JpaUtils.getEntityManager()) {
            LocalDateTime todayStart = LocalDate.now().atStartOfDay();
            return em.createQuery("SELECT s FROM Session s WHERE s.startDateTime >= :todayStart",
                            Session.class)
                    .setParameter("todayStart", todayStart)
                    .getResultList();
        }
    }
}
