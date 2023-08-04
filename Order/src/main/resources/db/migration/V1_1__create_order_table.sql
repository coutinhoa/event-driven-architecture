CREATE TABLE orders(
    id bigserial primary key,
    user_id int,
    total_price double precision
);



INSERT INTO orders (user_id, total_price) values (5, 0.90);
INSERT INTO orders (user_id, total_price) values (7, 1.3);
INSERT INTO orders (user_id, total_price) values (4, 4.30);
INSERT INTO orders (user_id, total_price) values (1, 1.20);
INSERT INTO orders (user_id, total_price) values (4, 2.99);
INSERT INTO orders (user_id, total_price) values (5, 4.30);
INSERT INTO orders (user_id, total_price) values (3, 1.49);



