CREATE TABLE trainings (
    id BIGSERIAL PRIMARY KEY,
    _timestamp TIMESTAMP NOT NULL,
    category TEXT NOT NULL,
    account_id INT NOT NULL
);