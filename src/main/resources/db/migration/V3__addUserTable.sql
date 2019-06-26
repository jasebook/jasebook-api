DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id bigserial PRIMARY KEY,
  username varchar(20) NOT NULL
);

create unique index users_username_uindex
    on users (username);

-- ALTER TABLE posts
--     ADD COLUMN user_id bigserial;
--
-- ALTER TABLE posts
--     ADD CONSTRAINT fk_posts_users FOREIGN KEY (user_id)
--         REFERENCES users (id);