CREATE TABLE book
(
  id    SERIAL PRIMARY KEY NOT NULL,
  title VARCHAR(255) NOT NULL,
  stock INTEGER DEFAULT 0 NOT NULL
);