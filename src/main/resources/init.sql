DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS meals;
DROP TABLE IF EXISTS menu;
DROP TABLE IF EXISTS restaurants;
DROP SEQUENCE IF EXISTS hibernate_sequence;

CREATE SEQUENCE hibernate_sequence START WITH 10000;
CREATE TABLE users
(
    id   INTEGER PRIMARY KEY DEFAULT nextval('hibernate_sequence'),
    name VARCHAR(255)
);

DROP TABLE IF EXISTS restaurants;
CREATE TABLE restaurants
(
    id   INTEGER PRIMARY KEY DEFAULT nextval('hibernate_sequence'),
    name VARCHAR(255)
);

CREATE TABLE menu
(
    id            INTEGER PRIMARY KEY DEFAULT nextval('hibernate_sequence'),
    date          DATE,
    restaurant_id INTEGER REFERENCES restaurants (id)
);

CREATE TABLE meals
(
    id      INTEGER PRIMARY KEY DEFAULT nextval('hibernate_sequence'),
    name    VARCHAR(255),
    menu_id INTEGER REFERENCES menu (id)
);

