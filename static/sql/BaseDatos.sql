
CREATE TABLE public.cliente (
	cliente_id bigserial NOT NULL,
	contrasena varchar(255) NULL,
	estado bool NOT NULL,
	direccion varchar(255) NULL,
	edad int4 NOT NULL,
	genero varchar(255) NULL,
	identificacion varchar(255) NULL,
	nombre varchar(255) NULL,
	telefono varchar(255) NULL,
	CONSTRAINT cliente_pkey PRIMARY KEY (cliente_id)
);


CREATE TABLE public.cuenta (
	id bigserial NOT NULL,
	cliente_id int8 NULL,
	estado bool NOT NULL,
	numero_cuenta int8 NULL,
	saldo_inicial numeric(19, 2) NULL,
	tipo_cuenta varchar(255) NULL,
	CONSTRAINT cuenta_pkey PRIMARY KEY (id)
);



CREATE TABLE public.movimiento (
	id bigserial NOT NULL,
	fecha timestamp NULL,
	saldo numeric(19, 2) NULL,
	tipo_movimiento varchar(255) NULL,
	valor numeric(19, 2) NULL,
	cuenta_id int8 NULL,
	CONSTRAINT movimiento_pkey PRIMARY KEY (id)
);


