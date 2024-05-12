
CREATE TABLE bdprueba.usuario (
	usuario_id BIGINT auto_increment NOT NULL COMMENT 'primary key',
	nombre varchar(100) NOT NULL,
	password varchar(100) NULL,
	CONSTRAINT usuario_PK PRIMARY KEY (usuario_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
AUTO_INCREMENT=1;

CREATE TABLE bdprueba.`purchase_order` (
	order_id BIGINT auto_increment NOT NULL,
	date_order DATE NOT NULL,
	status varchar(3) NULL,
	total DECIMAL NULL,
	CONSTRAINT order_PK PRIMARY KEY (order_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
AUTO_INCREMENT=1;

CREATE TABLE bdprueba.purchase_order_detail (
	detail_id BIGINT auto_increment NOT NULL,
	order_id BIGINT NOT NULL,
	product_id BIGINT NOT NULL,
	amount DECIMAL NOT NULL,
	unit_price DECIMAL NOT NULL,
	subtotal DECIMAL NOT NULL,
	CONSTRAINT purchase_order_detail_PK PRIMARY KEY (detail_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
AUTO_INCREMENT=1;

ALTER TABLE bdprueba.purchase_order_detail ADD CONSTRAINT purchase_order_detail_FK FOREIGN KEY (order_id) REFERENCES bdprueba.purchase_order(order_id);


