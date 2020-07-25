-- ROLES
INSERT INTO authority(id, authority) VALUES(1, 'CLIENTE');
INSERT INTO authority(id, authority) VALUES(2, 'EJECUTIVO');
INSERT INTO authority(id, authority) VALUES(3, 'ADMIN');

-- CREAR USUARIOS

INSERT INTO usuario(rut, nombre, apellido, clave) VALUES('170411927', 'EJECUTIVO', 'COMERCIAL','$2a$04$zhr0t9H8VVMT24mFszKvw.iRA8S71PUrYEllG6F/xtb6K3F9JMEYC');
INSERT INTO usuario(rut, nombre, apellido, clave) VALUES('c-1', 'USUARIO', 'UNO','$2a$04$zhr0t9H8VVMT24mFszKvw.iRA8S71PUrYEllG6F/xtb6K3F9JMEYC');
INSERT INTO usuario(rut, nombre, apellido, clave) VALUES('c-2', 'USUARIO', 'DOS','$2a$04$zhr0t9H8VVMT24mFszKvw.iRA8S71PUrYEllG6F/xtb6K3F9JMEYC');

-- EJECUTIVO
INSERT INTO ejecutivo(usuario_rut) VALUES('170411927');

-- CLIENTES
INSERT INTO cliente(usuario_rut, ejecutivofk) VALUES('c-1','170411927');
INSERT INTO cliente(usuario_rut, ejecutivofk) VALUES('c-2','170411927');

-- ASOCIAR ROLES
INSERT INTO authorities_users(usuario_id, authority_id) VALUES('170411927',2);
INSERT INTO authorities_users(usuario_id, authority_id) VALUES('c-1',1);
INSERT INTO authorities_users(usuario_id, authority_id) VALUES('c-2',1);