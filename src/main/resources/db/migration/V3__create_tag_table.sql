create table tag
(
    id   binary(16) primary key,
    name varchar(255) not null unique
);