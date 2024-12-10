package com.innowise.ticketbookingsystem.service;

import com.innowise.ticketbookingsystem.model.Session;
import com.innowise.ticketbookingsystem.repository.SessionRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public void createSession(Session session) {
        sessionRepository.save(session);
    }

    public void updateSession(Session session) {
        Optional<Session> existingSession = sessionRepository.findById(session.getId());
        if (existingSession.isEmpty()) {
            throw new IllegalArgumentException("Сеанс с ID " + session.getId() + " не найден.");
        }
        sessionRepository.update(session);
    }

    public Session getSessionById(UUID id) {
        return sessionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Сеанс с ID " + id + " не найден."));
    }

    public void deleteSession(UUID id) {
        Optional<Session> session = sessionRepository.findById(id);
        if (session.isEmpty()) {
            throw new IllegalArgumentException("Сеанс с ID " + id + " не найден.");
        }
        sessionRepository.deleteById(id);
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public List<Session> getSessionsByDate(LocalDate date) {
        return sessionRepository.findByDate(date);
    }

    public List<Session> getUpcomingSessions() {
        return sessionRepository.findFromToday();
    }


}
