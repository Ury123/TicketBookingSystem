CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO Movie (id, duration, title, poster_url) VALUES
  (uuid_generate_v4(), 100, 'Моана 2', 'https://ms1.relax.by/images/20e977928c5e456fb1e69ef5e6546406/thumb/w%3D600%2Ch%3D900%2Cq%3D81/afisha_event_photo/e9/df/c5/e9dfc54fe8b7a2f843c6576860cdeec5.jpg'),
  (uuid_generate_v4(), 112, 'Пятый битл', 'https://ms1.relax.by/images/20e977928c5e456fb1e69ef5e6546406/thumb/w%3D600%2Ch%3D900%2Cq%3D81/afisha_event_photo/53/79/37/5379375439b32e399bdb8c5af20596c1.jpg'),
  (uuid_generate_v4(), 123, 'Миссия: Красный', 'https://ms1.relax.by/images/20e977928c5e456fb1e69ef5e6546406/thumb/w%3D600%2Ch%3D900%2Cq%3D81/afisha_event_photo/92/57/7f/92577f3de6c7670445387672165fae41.jpg'),
  (uuid_generate_v4(), 98, 'Веном: Последний танец', 'https://ms1.relax.by/images/20e977928c5e456fb1e69ef5e6546406/thumb/w%3D600%2Ch%3D900%2Cq%3D81/afisha_event_photo/97/12/74/971274608121c00d56853f7a35ea7ca1.jpg'),
  (uuid_generate_v4(), 148, 'Гладиатор 2', 'https://ms1.relax.by/images/20e977928c5e456fb1e69ef5e6546406/thumb/w%3D600%2Ch%3D900%2Cq%3D81/afisha_event_photo/94/ae/bc/94aebc3f647231640d7f31a897b0bc38.jpg');

INSERT INTO Session (id, startDateTime, movie_id) VALUES
  (uuid_generate_v4(), '2024-12-11 10:00:00', (SELECT id FROM Movie WHERE title = 'Моана 2')),
  (uuid_generate_v4(), '2024-12-11 13:00:00', (SELECT id FROM Movie WHERE title = 'Пятый битл')),
  (uuid_generate_v4(), '2024-12-11 18:00:00', (SELECT id FROM Movie WHERE title = 'Пятый битл')),
  (uuid_generate_v4(), '2024-12-11 20:30:00', (SELECT id FROM Movie WHERE title = 'Миссия: Красный')),
  (uuid_generate_v4(), '2024-12-11 22:00:00', (SELECT id FROM Movie WHERE title = 'Веном: Последний танец')),
  (uuid_generate_v4(), '2024-12-12 10:00:00', (SELECT id FROM Movie WHERE title = 'Гладиатор 2')),
  (uuid_generate_v4(), '2024-12-12 12:00:00', (SELECT id FROM Movie WHERE title = 'Моана 2')),
  (uuid_generate_v4(), '2024-12-12 16:00:00', (SELECT id FROM Movie WHERE title = 'Гладиатор 2')),
  (uuid_generate_v4(), '2024-12-12 19:30:00', (SELECT id FROM Movie WHERE title = 'Веном: Последний танец')),
  (uuid_generate_v4(), '2024-12-10 19:30:00', (SELECT id FROM Movie WHERE title = 'Веном: Последний танец')),
  (uuid_generate_v4(), '2024-12-10 14:30:00', (SELECT id FROM Movie WHERE title = 'Веном: Последний танец')),
  (uuid_generate_v4(), '2024-12-09 14:30:00', (SELECT id FROM Movie WHERE title = 'Веном: Последний танец'));

INSERT INTO Users (id, email, password, user_role, username) VALUES
  (uuid_generate_v4(), 'bykovskijura792@gmail.com', '$2a$10$nqkQn1XF6yEeVyPNxpuTUerqAQDOW8Mnee3ozizAN9TUC0sH3AlXm', 'Admin', 'ury123456');

