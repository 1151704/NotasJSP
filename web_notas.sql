DROP DATABASE IF EXISTS web_notas;
CREATE DATABASE web_notas;

USE web_notas;

CREATE TABLE usuario (
	id int NOT NULL AUTO_INCREMENT,
	nombre varchar(50) NOT NULL,
	apellido varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	telefono varchar(50) NOT NULL,
	usuario varchar(50) NOT NULL unique,	
	password varchar(50) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE asignatura (
	id int NOT NULL AUTO_INCREMENT,
	idUsuario int NOT NULL,	
	nombre varchar(50) NOT NULL,
	creditos int NOT NULL,
	profesor varchar(50),
	promedioTotal decimal(3,1) NOT NULL DEFAULT '0.0',
	PRIMARY KEY (id), 
	FOREIGN KEY (idUsuario) REFERENCES usuario(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE asignaturaNota (
	idAsignatura int NOT NULL,	
	nombre varchar(50) NOT NULL,
	nota decimal(2,1) NOT NULL DEFAULT '0.0',
	porcentaje decimal(3,1) NOT NULL DEFAULT '0.0',
	FOREIGN KEY (idAsignatura) REFERENCES asignatura(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DELIMITER $$ 
DROP TRIGGER IF EXISTS asignaturaNota_update $$
CREATE TRIGGER asignaturaNota_update AFTER UPDATE ON asignaturaNota
FOR EACH ROW BEGIN

	set @newTotal = (select sum(nota * porcentaje * 0.01) as total from asignaturaNota where old.idAsignatura);
	
	set @oldTotal = (select promedioTotal from asignatura WHERE id = old.idAsignatura);
	
	if (@newTotal != @oldTotal) then
		update asignatura set promedioTotal = @newTotal where id = old.idAsignatura;
	end if;
    
END
$$
DELIMITER ;

INSERT INTO usuario (nombre, apellido, email, telefono, usuario, password) values ('Omar', 'Ramón', 'omar@gmail.com', '555-5555', 'root', 'root');

INSERT INTO asignatura (nombre, profesor, creditos, promedioTotal, idUsuario) values ('Programación web', 'Carlos Angarita', 3, '0', 1);
INSERT INTO asignatura (nombre, profesor, creditos, promedioTotal, idUsuario) values ('Análisis de algoritmos', 'Marco Adarme', 3, '0', 1);

INSERT INTO asignaturaNota (idAsignatura, nombre, nota, porcentaje) values (1, 'Nota 1', 0, '23.3');
INSERT INTO asignaturaNota (idAsignatura, nombre, nota, porcentaje) values (1, 'Nota 2', 0, '22.3');
INSERT INTO asignaturaNota (idAsignatura, nombre, nota, porcentaje) values (1, 'Nota 3', 0, '23.3');
INSERT INTO asignaturaNota (idAsignatura, nombre, nota, porcentaje) values (1, 'Nota 4', 0, '30');

INSERT INTO asignaturaNota (idAsignatura, nombre, nota, porcentaje) values (2, 'Nota 1', 0, '23.3');
INSERT INTO asignaturaNota (idAsignatura, nombre, nota, porcentaje) values (2, 'Nota 2', 0, '23.3');
INSERT INTO asignaturaNota (idAsignatura, nombre, nota, porcentaje) values (2, 'Nota 3', 0, '23.3');
INSERT INTO asignaturaNota (idAsignatura, nombre, nota, porcentaje) values (2, 'Nota 4', 0, '30');
