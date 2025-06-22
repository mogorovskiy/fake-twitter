create table author
(
    id binary(16) primary key,
    name varchar(255) not null,
    email varchar(255) not null unique,
    password varchar(255) not null,
    created_at datetime not null
);