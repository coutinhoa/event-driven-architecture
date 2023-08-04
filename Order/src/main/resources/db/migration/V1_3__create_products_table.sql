CREATE TABLE products(
    id bigserial primary key,
    name character VARYING NOT NULL,
    price double precision
);



INSERT INTO products (id, name, price) values (1, 'Orange', 0.90);
INSERT INTO products (id, name, price) values (2, 'Apple', 1.3);
INSERT INTO products (id, name, price) values (3, 'Meat', 4.30);
INSERT INTO products (id, name, price) values (4, 'Juice', 1.20);
INSERT INTO products (id, name, price) values (5, 'Yoghurt', 2.99);
INSERT INTO products (id, name, price) values (6, 'Toilet Paper', 4.30);
INSERT INTO products (id, name, price) values (7, 'Chocolate', 1.49);



