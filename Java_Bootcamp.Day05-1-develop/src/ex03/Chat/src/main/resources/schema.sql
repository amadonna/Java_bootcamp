drop schema if exists chat cascade;
create schema if not exists chat;

create table if not exists chat.User (
    id serial primary key,
    login text unique not null,
    password text not null
);

create table if not exists chat.Rooms (
    id serial primary key,
    name text unique not null,
    owner integer references chat.User(id) not null
);

create table if not exists chat.Messages (
    id serial primary key,
    author integer references chat.User(id),
    room integer references chat.Rooms(id),
    text text not null,
    timestamp timestamp not null
);