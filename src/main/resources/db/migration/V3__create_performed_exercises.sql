CREATE TABLE performed_exercises (
    id BIGSERIAL PRIMARY KEY,
    training_id BIGINT,
    exercise_id BIGINT,
    sort_id BIGINT
);