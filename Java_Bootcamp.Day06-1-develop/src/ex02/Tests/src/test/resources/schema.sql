drop table if exists Product;
create table  Product (
                          id identity primary key,
                          name varchar(255),
                          price int
);