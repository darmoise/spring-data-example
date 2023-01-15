CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE person (
    id         UUID NOT NULL DEFAULT uuid_generate_v4(),
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    username   VARCHAR(255) NOT NULL,
    birth_date TIMESTAMP NOT NULL,
    version    INT NOT NULL,

    CONSTRAINT pk_person_id PRIMARY KEY (id)
);

CREATE TABLE hobby (
    id         UUID NOT NULL DEFAULT uuid_generate_v4(),
    name       VARCHAR(255) NOT NULL,
    start_age  INT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT current_timestamp,
    updated_at TIMESTAMP NOT NULL,
    person_id  UUID NOT NULL,

    CONSTRAINT pk_hobby_id PRIMARY KEY (id)
);