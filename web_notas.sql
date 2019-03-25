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


INSERT INTO usuario (nombre, apellido, email, telefono, usuario, password) values ('Omar', 'Ramón', 'omar@gmail.com', '555-5555', 'root', 'root');

INSERT INTO asignatura (nombre, profesor, creditos, promedioTotal, idUsuario) values ('Programación web', 'Carlos Angarita', 3, '0', 1);
INSERT INTO asignatura (nombre, profesor, creditos, promedioTotal, idUsuario) values ('Análisis de algoritmos', 'Marco Adarme', 3, '0', 1);

INSERT INTO asignaturaNota (idAsignatura, nombre, nota, porcentaje) values (1, 'Nota 1', 0, '23,3');
INSERT INTO asignaturaNota (idAsignatura, nombre, nota, porcentaje) values (1, 'Nota 2', 0, '23,3');
INSERT INTO asignaturaNota (idAsignatura, nombre, nota, porcentaje) values (1, 'Nota 3', 0, '23,3');
INSERT INTO asignaturaNota (idAsignatura, nombre, nota, porcentaje) values (1, 'Nota 4', 0, '30');

INSERT INTO asignaturaNota (idAsignatura, nombre, nota, porcentaje) values (2, 'Nota 1', 0, '23,3');
INSERT INTO asignaturaNota (idAsignatura, nombre, nota, porcentaje) values (2, 'Nota 2', 0, '23,3');
INSERT INTO asignaturaNota (idAsignatura, nombre, nota, porcentaje) values (2, 'Nota 3', 0, '23,3');
INSERT INTO asignaturaNota (idAsignatura, nombre, nota, porcentaje) values (2, 'Nota 4', 0, '30');