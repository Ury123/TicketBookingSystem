package com.innowise.ticketbookingsystem.repository;

import com.innowise.ticketbookingsystem.model.Session;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SessionRepository {

    //Сохранить сеанс в базу данных.
    public void save(Session session);

    //обновить сеанс.
    public void update(Session session);

    //Найти сеанс по ID.
    public Optional<Session> findById(UUID id);

    //Удалить сеанс по ID.
    public void deleteById(UUID id);

    //Найти все сеансы.
    public List<Session> findAll();

    //Найти все сеансы, которые проходят в указанную дату.
    public List<Session> findByDate(LocalDate date);

    //Найти все сеансы, которые начинаются с сегодняшней даты.
    public List<Session> findFromToday();
}
