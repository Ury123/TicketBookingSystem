create table Movie (
       id uuid not null,
        duration integer not null,
        title varchar(255) not null,
        primary key (id)
);

create table Seat (
       id uuid not null,
        number integer not null,
        row integer not null,
        primary key (id)
);

create table Session (
       id uuid not null,
        startDateTime Timestamp(6) not null,
        movie_id uuid,
        primary key (id)
);

create table Session_seat (
       id uuid not null,
        seat_id uuid,
        session_id uuid,
        primary key (id)
);

create table Ticket (
       id uuid not null,
        session_seat_id uuid,
        user_id uuid,
        primary key (id)
);

create table users (
       id uuid not null,
        email varchar(255) not null,
        password varchar(255) not null,
        user_role varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
);