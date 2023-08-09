CREATE TABLE products(
    id bigserial primary key,
    name character VARYING NOT NULL,
    price double precision,
    warehouse_quantity int
);



INSERT INTO products (name, price, warehouse_quantity) values ('Orange', 0.90, 10);
INSERT INTO products (name, price, warehouse_quantity) values ('Apple', 1.3, 0);
INSERT INTO products (name, price, warehouse_quantity) values ('Meat', 4.30, 0);
INSERT INTO products (name, price, warehouse_quantity) values ('Juice', 1.20, 6);
INSERT INTO products (name, price, warehouse_quantity) values ('Yoghurt', 2.99, 7);
INSERT INTO products (name, price, warehouse_quantity) values ('Toilet Paper', 4.30, 8);
INSERT INTO products (name, price, warehouse_quantity) values ('Chocolate', 1.49, 1);
INSERT INTO products (name, price, warehouse_quantity) values ('Greek Yoghurt', 0.70, 3);
INSERT INTO products (name, price, warehouse_quantity) values ('White Chocolate', 1.3, 5);
INSERT INTO products (name, price, warehouse_quantity) values ('Shower Gel', 3.30, 2);
INSERT INTO products (name, price, warehouse_quantity) values ('Fish', 1.20, 1);
INSERT INTO products (name, price, warehouse_quantity) values ('Shampoo', 3.99, 7);
INSERT INTO products (name, price, warehouse_quantity) values ('Cheese', 4.30, 0);
INSERT INTO products (name, price, warehouse_quantity) values ('Bread', 1.49, 5);
INSERT INTO products (name, price, warehouse_quantity) values ('Milk', 0.99, 2);

