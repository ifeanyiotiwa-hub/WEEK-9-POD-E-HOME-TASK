DROP TABLE IF EXISTS person;

CREATE TABLE IF NOT EXISTS person(
    id serial PRIMARY KEY,
    first_name varchar(130) NOT NULL,
    last_name varchar(130) NOT NULL,
    email varchar(50) NOT NULL UNIQUE,
    password varchar(50) NOT NULL,
    nationality varchar(50) NOT NULL,
    birth_date date NOT NULL

);