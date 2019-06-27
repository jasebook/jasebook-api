
ALTER TABLE posts ADD FOREIGN KEY (user_id) REFERENCES users(user_id);