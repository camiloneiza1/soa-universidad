INSERT INTO usuarios(username, password, enabled, nombre, apellido, email) VALUES('andres','$2a$10$skvht/CLPcTHCFsKWS4VJeK1JI8QjnbC9NKSsteIunI8.VqDlUPka',1,'Andres','Perez','aperez@gmail.com');
INSERT INTO usuarios(username, password, enabled, nombre, apellido, email) VALUES('admin','$2a$10$kkcoZychzdYq5ZYwSTXm4eIN0bCwTbVHpiBkZq4JY/SHh17ApCxXS',1,'Luis','Pulido','lpulido@gmail.com');

INSERT INTO roles(nombre) VALUES('ROLE_USER');
INSERT INTO roles(nombre) VALUES('ROLE_ADMIN'); 

INSERT INTO usuario_roles(usuario_id,roles_id) VALUES(1,1);
INSERT INTO usuario_roles(usuario_id,roles_id) VALUES(2,2);
INSERT INTO usuario_roles(usuario_id,roles_id) VALUES(2,1);