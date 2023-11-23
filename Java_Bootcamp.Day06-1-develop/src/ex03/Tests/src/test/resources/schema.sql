drop table if exists Product;
create table  Product (
                          id identity primary key,
                          name varchar(255),
                          price int
);

drop table if exists User;
create table  User (
                          id identity primary key,
                          login varchar(255),
                          password varchar(255),
                          authStatus boolean
);