CREATE TABLE IF NOT EXISTS GEBRUIKER
(
    id integer not null AUTO_INCREMENT,
    username VARCHAR(45) not null,
    password VARCHAR(45) not null,
    algorithm VARCHAR(45) not null,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS AUTHORITY
(
    id integer not null AUTO_INCREMENT,
    authorityname VARCHAR(45) NOT NULL,
    userid VARCHAR(45) NOT NULL,
    primary key(id)
);

CREATE TABLE IF NOT EXISTS GUITAR
(
    id integer not null AUTO_INCREMENT,
    brand VARCHAR(45) NOT NULL,
    model VARCHAR(45) NOT NULL,
    genre VARCHAR(45) NOT NULL,
    primary key(id)
);