CREATE TABLE anthropometry (
    id         UUID NOT NULL DEFAULT uuid_generate_v4(),
    height     INT NOT NULL,
    weight     INT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT current_timestamp,
    updated_at TIMESTAMP NOT NULL,
    person_id  UUID NOT NULL,

    CONSTRAINT pk_anthropometry_id PRIMARY KEY (id)
);

