CREATE TABLE isbn13
(
  book_id INTEGER NOT NULL REFERENCES book(id) ON DELETE CASCADE,
  isbn    VARCHAR(255) NOT NULL
);