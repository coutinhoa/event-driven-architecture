CREATE TABLE shopping_cart(
    id bigserial primary key,
    name character VARYING NOT NULL,
    quantity int
);



INSERT INTO shopping_cart (name, quantity) values ('Orange', 6);
INSERT INTO shopping_cart (name, quantity) values ('Yoghurt', 3);
INSERT INTO shopping_cart (name, quantity) values ('Juice', 1);



