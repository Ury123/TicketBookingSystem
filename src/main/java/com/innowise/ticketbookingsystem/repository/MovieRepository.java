package com.innowise.ticketbookingsystem.repository;

import com.innowise.ticketbookingsystem.model.Movie;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieRepository {

    //Сохранить фильм в базу данных.
    public void save(Movie movie);

    //Обновить фильм.
    public void update(Movie movie);

    //Найти фильм по ID.
    public Optional<Movie> findById(UUID id);

    //Удалить фильм по ID.
    public void deleteById(UUID id);

    //Найти все сеансы.
    public List<Movie> findAll();

    //Найти фильмы по названию
    public List<Movie> findByTitle(String title);

}
