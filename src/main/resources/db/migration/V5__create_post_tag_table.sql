create table post_tag
(
    post_id char(36) not null,
    tag_id  char(36) not null,
    primary key (post_id, tag_id),
    constraint fk_post_tag_post
        foreign key (post_id)
            references post (id)
            on delete cascade,
    constraint fk_post_tag_tag
        foreign key (tag_id)
            references tag (id)
            on delete cascade
);