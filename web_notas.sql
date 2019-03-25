DROP DATABASE IF EXISTS web_notas;
CREATE DATABASE web_notas;

USE web_notas;

CREATE TABLE usuario (
	id int NOT NULL AUTO_INCREMENT,
	nombre varchar(50) NOT NULL,
	apellido varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	telefono varchar(50) NOT NULL,
	usuario varchar(50) NOT NULL,	
	password varchar(50) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE asignatura (
	id int NOT NULL AUTO_INCREMENT,
	idUsuario int NOT NULL,	
	nombre varchar(50) NOT NULL,
	creditos int NOT NULL,
	profesor varchar(50),
	promedioTotal double NOT NULL,
	PRIMARY KEY (id), 
	FOREIGN KEY (idUsuario) REFERENCES usuario(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE asignaturaNota (
	idAsignatura int NOT NULL,	
	nombre varchar(50) NOT NULL,
	nota double NOT NULL,
	porcentaje double NOT NULL,
	FOREIGN KEY (idAsignatura) REFERENCES asignatura(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
