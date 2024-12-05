-- Уникальные ограничения
alter table  Movie
   add constraint unique_movie_title unique (title);

alter table users
   add constraint unique_users_email unique (email);

alter table users
   add constraint unique_users_username unique (username);

-- Внешние ключи
alter table Session
   add constraint fk_session_movie
   foreign key (movie_id)
   references Movie;

alter table Session_seat
   add constraint fk_sessionseat_seat
   foreign key (seat_id)
   references Seat;

alter table Session_seat
   add constraint fk_sessionseat_session
   foreign key (session_id)
   references Session;

alter table Ticket
   add constraint fk_ticket_sessionseat
   foreign key (session_seat_id)
   references Session_seat;

alter table Ticket
   add constraint fk_ticket_user
   foreign key (user_id)
   references users;