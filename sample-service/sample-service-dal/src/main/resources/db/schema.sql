CREATE TABLE public.shopping_cart (
	id bigserial NOT NULL,
	shopping_cart_id varchar(255) NULL,
	user_id varchar(255) NULL,
	CONSTRAINT shopping_cart_pkey PRIMARY KEY (id),
	CONSTRAINT uk_3584orgbl4dctn9vkh6crf6kt UNIQUE (shopping_cart_id),
	CONSTRAINT uk_qx5dh8nhlnh77h8im91vlqwdv UNIQUE (user_id)
);

CREATE TABLE public.item (
	id bigserial NOT NULL,
	price float8 NULL,
	product_id varchar(255) NULL,
	quantity int4 NULL,
	shopping_cart_id int8 NULL,
	CONSTRAINT item_pkey PRIMARY KEY (id)
);

ALTER TABLE public.item ADD CONSTRAINT fkb4v596wqde51kaljt9epgnyaq FOREIGN KEY (shopping_cart_id) REFERENCES shopping_cart(id);