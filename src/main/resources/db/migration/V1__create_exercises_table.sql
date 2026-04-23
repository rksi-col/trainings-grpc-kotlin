CREATE TABLE exercises (
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    target_muscle TEXT NOT NULL
);

CREATE TABLE trainings (
    id BIGSERIAL PRIMARY KEY,
    _timestamp TIMESTAMP NOT NULL,
    category TEXT NOT NULL,
    account_id INT NOT NULL
);

CREATE TABLE workout_exercises (
    id BIGSERIAL PRIMARY KEY,
    training_id BIGINT NOT NULL REFERENCES trainings(id) ON DELETE CASCADE,
    exercise_id BIGINT NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    sort_id BIGINT NOT NULL
);
