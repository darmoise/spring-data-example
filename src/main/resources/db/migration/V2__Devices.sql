CREATE TABLE devices (
    id UUID NOT NULL DEFAULT uuid_generate_v4(),
    name VARCHAR(255) NOT NULL,
    start_date TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT current_timestamp,
    updated_at TIMESTAMP NOT NULL,
    user_id UUID NOT NULL,
    CONSTRAINT pk_devices_id PRIMARY KEY (id)
);