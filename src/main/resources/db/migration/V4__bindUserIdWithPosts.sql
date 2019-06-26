alter table posts
    add user_id bigserial;

alter table posts
    add constraint posts_users_id_fk
        foreign key (user_id) references users (id)
            on update cascade on delete cascade;