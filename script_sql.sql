
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
