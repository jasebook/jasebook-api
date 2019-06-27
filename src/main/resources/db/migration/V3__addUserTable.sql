DROP TABLE IF EXISTS users;

CREATE TABLE users (
  user_id bigserial PRIMARY KEY,
  username varchar(20) NOT NULL
);

create unique index users_username_uindex
    on users (username);
