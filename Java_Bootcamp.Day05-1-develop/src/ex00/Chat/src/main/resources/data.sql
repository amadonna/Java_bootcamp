insert  into chat."user" (login, password) values
        ('Bolot', '12345'),
        ('Darina', '12345'),
        ('Kamil', '12345'),
        ('Dima', '12345'),
        ('Rinat', '12345');

insert into chat.rooms (name, owner) values
        ('Sh1', 1),
        ('Tseh', 2),
        ('KAI', 5),
        ('Hostel', 3),
        ('Tra', 4);


insert into chat.messages (author, room, text, timestamp)  values
        (1, 1, 'hi', '2023-01-01 00:00:01'),
        (2, 1, 'Hello', '2023-01-01 00:05:01'),
        (3, 2, 'Welcome to the chat room!', '2023-01-01 00:10:01'),
        (1, 2, 'How is everyone doing?', '2023-01-01 00:15:01'),
        (4, 1, 'Good morning!', '2023-01-01 00:20:01');


