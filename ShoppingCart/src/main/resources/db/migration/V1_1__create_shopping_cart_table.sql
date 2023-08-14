CREATE TABLE shopping_cart(
    id bigserial primary key,
    user_id bigserial NOT NULL,
    totalPrice double,
    productQuantities MAP<bigserial, integer>
);




