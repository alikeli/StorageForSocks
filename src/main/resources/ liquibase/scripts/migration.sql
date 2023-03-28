--liquibase formatted sql

--changeset alikeli:1

CREATE TABLE IF NOT EXISTS socks
(
    socks_id SERIAL PRIMARY KEY,
    color VARCHAR(50) NOT NULL,
    cotton_part INT NOT NULL,
    quantity INT NOT NULL
    )