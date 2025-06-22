create table post
(
    id           char(36) primary key,
    title        varchar(255) not null,
    content      text         not null,
    created_at   datetime     not null,
    updated_at   datetime     not null,
    status       varchar(50)  not null,
    reading_time int          not null,
    author_id    char(36)     not null,
    category_id  char(36)     not null,
    constraint fk_post_author
        foreign key (author_id)
            references author (id)
            on delete cascade,
    constraint fk_post_category
        foreign key (category_id)
            references category (id)
            on delete restrict,
    CONSTRAINT check_post_status
        CHECK (status IN ('DRAFT', 'PUBLISHED'))
);