create table tag
(
    id   char(36) primary key,
    name varchar(255) not null unique
);