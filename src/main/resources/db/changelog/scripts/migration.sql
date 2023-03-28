--liquibase formatted sql

--changeset alikeli:1

CREATE TABLE IF NOT EXISTS socks
(
    socks_id SERIAL PRIMARY KEY,
    color VARCHAR(50) NOT NULL,
    cotton_part INT NOT NULL CHECK(cotton_part >= 0 AND cotton_part <= 100),
    amount INT NOT NULL CHECK (amount >= 0)
    );

--changeset alikeli:2

INSERT INTO socks (color, cotton_part, amount)
values ('purple', 70, 10);
