-- -----------------------------------------------------
-- Table acceso
-- -----------------------------------------------------
create table acceso(
  acceso_id serial not null,
  nombre varchar(140) not null,
  objeto varchar(250) not null,
  descripcion varchar(250) not null,
  fecha_hora_creacion timestamp without time zone NOT NULL default current_timestamp,
  fecha_hora_modificacion timestamp without time zone NULL,
  activo boolean not null default '1'
);
-- -----------------------------------------------------
-- Table autor
-- -----------------------------------------------------
CREATE TABLE  autor (
  autor_id bigserial NOT NULL ,
  nombres VARCHAR(255) NOT NULL ,
  paterno VARCHAR(255) NOT NULL ,
  materno VARCHAR(255) NULL,
  tipo_autor int NULL ,
  fecha_hora_creacion timestamp without time zone NOT NULL default current_timestamp,
  fecha_hora_modificacion timestamp without time zone NULL,
  activo boolean not null default '1');
-- -----------------------------------------------------
-- Table editorial
-- -----------------------------------------------------
CREATE TABLE  editorial (
  editorial_id serial NOT NULL ,
  nombre VARCHAR(255) NOT NULL,
  fecha_hora_creacion timestamp without time zone NOT NULL default current_timestamp,
  fecha_hora_modificacion timestamp without time zone NULL,
  activo boolean not null default '1');
-- -----------------------------------------------------
-- Table ejemplar
-- -----------------------------------------------------
CREATE TABLE  ejemplar (
  ejemplar_id bigserial NOT NULL ,
  codigo varchar(50) not null,
  fecha_entrada DATE NULL ,
  estado INT NOT NULL , -- 0 = no disponible / 1 = disponible
  libro_id bigint NOT NULL ,
  procedencia_id INT NOT NULL ,
  prestamo_activo_id bigint null,
  fecha_hora_creacion timestamp without time zone NOT NULL default current_timestamp,
  fecha_hora_modificacion timestamp without time zone NULL,
  activo boolean not null default '1');
-- -----------------------------------------------------
-- Table evento
-- -----------------------------------------------------
CREATE TABLE evento(
  evento_id bigserial not null,
  tipo char(1) not null, -- C = CREATE, U = UPDATE, D = DELETE, L = LOGIN
  fecha_hora timestamp without time zone not null,
  usuario_id bigserial not null,
  tabla varchar(140) null,
  direccion_ip varchar(16) not null,
  direccion_mac varchar(23) not null);
-- -----------------------------------------------------
-- Table evento_detalle
-- -----------------------------------------------------
CREATE TABLE evento_detalle(
  evento_detalle_id bigserial not null,
  columna varchar(140) not null,
  valor_antiguo varchar(255) null,
  valor_nuevo varchar(255) null,
  evento_id bigserial not null);
-- -----------------------------------------------------
-- Table indice
-- -----------------------------------------------------
CREATE TABLE  indice (
  indice_id bigserial NOT NULL ,
  orden int not null,
  descripcion VARCHAR(255) NOT NULL ,
  libro_id bigint not null,
  fecha_hora_creacion timestamp without time zone NOT NULL default current_timestamp,
  fecha_hora_modificacion timestamp without time zone NULL);
-- -----------------------------------------------------
-- Table libro
-- -----------------------------------------------------
CREATE TABLE  libro (
  libro_id bigserial NOT NULL ,
  titulo VARCHAR(255) NOT NULL ,
  numero INT NULL ,
  volumen INT NULL ,
  tomo INT NULL ,
  numero_paginas INT NOT NULL ,
  numero_edicion INT NOT NULL ,
  fecha_publicacion DATE NULL ,
  isbn10 CHAR(10) NULL ,
  isbn13 CHAR(13) NULL ,
  direccion_fichero VARCHAR(255) NULL ,
  formato INT NOT NULL ,
  seccion_id INT NOT NULL ,
  ejemplar_total int not null default '0',
  ejemplar_disponible int not null default '0',
  tipo_libro_id INT NOT NULL ,
  editorial_id INT NOT NULL,
  fecha_hora_creacion timestamp without time zone NOT NULL default current_timestamp,
  fecha_hora_modificacion timestamp without time zone NULL,
  activo boolean not null default '1');
-- -----------------------------------------------------
-- Table libro_autor
-- -----------------------------------------------------
CREATE TABLE  libro_autor (
  libro_autor_id bigserial NOT NULL,
  libro_id bigint NOT NULL,
  autor_id bigint NOT NULL,
  fecha_hora_creacion timestamp without time zone NOT NULL default current_timestamp,
  fecha_hora_modificacion timestamp without time zone NULL);
-- -----------------------------------------------------
-- Table libro_tema
-- -----------------------------------------------------
CREATE TABLE  libro_tema (
  libro_tema_id bigserial NOT NULL ,
  tema_id int NOT NULL ,
  libro_id bigint NOT NULL,
  fecha_hora_creacion timestamp without time zone NOT NULL default current_timestamp,
  fecha_hora_modificacion timestamp without time zone NULL);
-- -----------------------------------------------------
-- Table materia
-- -----------------------------------------------------
CREATE TABLE  materia (
  materia_id serial NOT NULL,
  nombre VARCHAR(255) NOT NULL ,
  descripcion VARCHAR(255) NULL ,
  fecha_hora_creacion timestamp without time zone NOT NULL default current_timestamp,
  fecha_hora_modificacion timestamp without time zone NULL,
  activo boolean not null default '1');
-- -----------------------------------------------------
-- Table persona
-- -----------------------------------------------------
CREATE TABLE  persona (
  persona_id bigserial NOT NULL ,
  nombres VARCHAR(255) NOT NULL ,
  paterno VARCHAR(255) NOT NULL ,
  materno varchar(255) not null,
  dni VARCHAR(12) NOT NULL ,
  telefono VARCHAR(12) NULL ,
  celular VARCHAR(12) NULL ,
  email VARCHAR(100) NULL ,
  fecha_hora_creacion timestamp without time zone NOT NULL default current_timestamp,
  fecha_hora_modificacion timestamp without time zone NULL,
  activo boolean not null default '1');
-- -----------------------------------------------------
-- Table prestamo
-- -----------------------------------------------------
CREATE TABLE  prestamo (
  prestamo_id bigserial NOT NULL ,
  fecha_prestamo DATE NOT NULL ,
  fecha_devolucion DATE NOT NULL ,
  fecha_entrega DATE NULL ,
  atraso INT NULL ,
  multa_pagada numeric(10,2) NULL ,
  ejemplar_id bigint NOT NULL ,
  persona_id bigint NOT NULL,
  observaciones varchar(255) null,
  fecha_hora_creacion timestamp without time zone NOT NULL default current_timestamp,
  fecha_hora_modificacion timestamp without time zone NULL);
-- -----------------------------------------------------
-- Table procedencia
-- -----------------------------------------------------
CREATE TABLE  procedencia (
  procedencia_id serial NOT NULL ,
  nombre VARCHAR(255) NOT NULL ,
  descripcion VARCHAR(255) NULL ,
  fecha_hora_creacion timestamp without time zone NOT NULL default current_timestamp,
  fecha_hora_modificacion timestamp without time zone NULL);
-- -----------------------------------------------------
-- Table rol
-- -----------------------------------------------------
CREATE TABLE rol (
  rol_id serial NOT NULL ,
  nombre VARCHAR(255) NOT NULL ,
  activo boolean NOT NULL,
  fecha_hora_creacion timestamp without time zone NOT NULL default current_timestamp,
  fecha_hora_modificacion timestamp without time zone NULL);
-- -----------------------------------------------------
-- Table rol_acceso
-- -----------------------------------------------------
create table rol_acceso(
  rol_acceso_id bigserial not null,
  acceso_id int not null,
  rol_id int not null,
  crud char(4) not null default '0000',
  fecha_hora_creacion timestamp without time zone NOT NULL default current_timestamp,
  fecha_hora_modificacion timestamp without time zone NULL);
-- -----------------------------------------------------
-- Table seccion
-- -----------------------------------------------------
CREATE TABLE  seccion (
  seccion_id serial NOT NULL ,
  nombre VARCHAR(255) NOT NULL ,
  descripcion VARCHAR(255) NULL ,
  materia_id INT NOT NULL ,
  fecha_hora_creacion timestamp without time zone NOT NULL default current_timestamp,
  fecha_hora_modificacion timestamp without time zone NULL,
  activo boolean not null default '1');
-- -----------------------------------------------------
-- Table tema
-- -----------------------------------------------------
CREATE TABLE tema (
  tema_id serial NOT NULL,
  nombre VARCHAR(255) NOT NULL ,
  descripcion VARCHAR(255) NULL ,
  cantidad_subtema INT not null default '0',
  tema_superior_id INT null ,
  fecha_hora_creacion timestamp without time zone NOT NULL default current_timestamp,
  fecha_hora_modificacion timestamp without time zone NULL,
  activo boolean not null default '1');
-- -----------------------------------------------------
-- Table tipo_libro
-- -----------------------------------------------------
CREATE TABLE tipo_libro (
  tipo_libro_id serial NOT NULL ,
  nombre varchar(140) not null,
  descripcion VARCHAR(255) NULL ,
  fecha_hora_creacion timestamp without time zone NOT NULL default current_timestamp,
  fecha_hora_modificacion timestamp without time zone NULL,
  activo boolean not null default '1');
-- -----------------------------------------------------
-- Table usuario
-- -----------------------------------------------------
CREATE TABLE  usuario (
  usuario_id bigserial NOT NULL ,
  login VARCHAR(40) NOT NULL ,
  password VARCHAR(100) NOT NULL ,
  activo boolean NOT NULL ,
  cambiar_password boolean NOT NULL ,
  persona_id bigint NULL,
  rol_id bigint not null,
  evento_id bigint not null,
  fecha_hora_creacion timestamp without time zone NOT NULL default current_timestamp,
  fecha_hora_modificacion timestamp without time zone NULL);
-- -----------------------------------------------------
-- Table usuario_rol
-- -----------------------------------------------------
-- CREATE TABLE  usuario_rol (
--   usuario_rol_id bigserial NOT NULL ,
--   usuario_id bigint NOT NULL ,
--   rol_id int NOT NULL,
--   fecha_hora_creacion timestamp without time zone NOT NULL default current_timestamp,
--   fecha_hora_modificacion timestamp without time zone NULL);

-- CONSTRAINTS
alter table acceso add constraint pk_acceso primary key(acceso_id);

alter table autor add constraint pk_autor primary key(autor_id);

alter table editorial add constraint pk_editorial primary key(editorial_id);

alter table ejemplar add constraint pk_ejemplar primary key(ejemplar_id);

alter table evento add constraint pk_evento primary key(evento_id);

alter table evento_detalle add constraint pk_evento_detalle primary key(evento_detalle_id);

alter table indice add constraint pk_indice primary key(indice_id);

alter table libro add constraint pk_libro primary key(libro_id);

alter table libro_autor add constraint pk_libro_autor primary key(libro_autor_id);

alter table libro_tema add constraint pk_libro_tema primary key(libro_tema_id);

alter table materia add constraint pk_materia primary key(materia_id);

alter table persona add constraint pk_persona primary key(persona_id);

alter table prestamo add constraint pk_prestamo primary key(prestamo_id);

alter table procedencia add constraint pk_procedencia primary key(procedencia_id);

alter table rol add constraint pk_rol primary key(rol_id);

alter table rol_acceso add constraint pk_rol_acceso primary key(rol_acceso_id);

alter table seccion add constraint pk_seccion primary key(seccion_id);

alter table tema add constraint pk_tema primary key(tema_id);

alter table tipo_libro add constraint pk_tipo_libro primary key(tipo_libro_id);

alter table usuario add constraint pk_usuario primary key (usuario_id);

alter table ejemplar add constraint fk_ejemplar_libro foreign key(libro_id) references libro(libro_id);
alter table ejemplar add constraint fk_ejemplar_procedencia foreign key(procedencia_id) references procedencia(procedencia_id);
alter table ejemplar add constraint fk_ejemplar_prestamo foreign key(prestamo_activo_id) references prestamo(prestamo_id);

alter table evento add constraint fk_evento_usuario foreign key(usuario_id) references usuario(usuario_id);

alter table evento_detalle add constraint fk_evento_detalle_evento foreign key(evento_id) references evento(evento_id);

alter table indice add constraint fk_indice_libro foreign key(libro_id) references libro(libro_id);

alter table libro add constraint fk_libro_seccion foreign key(seccion_id) references seccion(seccion_id);
alter table libro add constraint fk_libro_tipo_libro foreign key(tipo_libro_id) references tipo_libro(tipo_libro_id);
alter table libro add constraint fk_libro_editorial foreign key(editorial_id) references editorial(editorial_id);

alter table libro_autor add constraint fk_libro_autor_libro foreign key(libro_id) references libro(libro_id);
alter table libro_autor add constraint fk_libro_autor_autor foreign key(autor_id) references autor(autor_id);
alter table libro_autor add constraint uq_libro_autor unique(libro_id,autor_id);

alter table libro_tema add constraint fk_libro_tema_tema foreign key(tema_id) references tema(tema_id);
alter table libro_tema add constraint fk_libro_tema_libro foreign key(libro_id) references libro(libro_id);
alter table libro_tema add constraint uq_libro_tema unique(tema_id,libro_id);

alter table prestamo add constraint fk_prestamo_ejemplar foreign key(ejemplar_id) references ejemplar(ejemplar_id);
alter table prestamo add constraint fk_prestamo_persona foreign key(persona_id) references persona(persona_id);

alter table rol_acceso add constraint fk_rol_acceso_rol foreign key (rol_id) references rol(rol_id);
alter table rol_acceso add constraint fk_rol_acceso_acceso foreign key (acceso_id) references acceso(acceso_id);
alter table rol_acceso add constraint uq_rol_acceso unique(rol_id,acceso_id);

alter table tema add constraint fk_tema_tema foreign key(tema_superior_id) references tema(tema_id);

alter table seccion add constraint fk_seccion_materia foreign key(materia_id) references materia(materia_id);

alter table usuario add constraint fk_usuario_persona foreign key(persona_id) references persona(persona_id);
alter table usuario add constraint fk_usuario_rol foreign key(rol_id) references rol(rol_id);
alter table usuario add constraint fk_usuario_evento foreign key(evento_id) references evento(evento_id);


-- alter table usuario_rol add constraint pk_usuario_rol primary key(usuario_rol_id);
-- alter table usuario_rol add constraint fk_usuario_rol_usuario foreign key(usuario_id) references usuario(usuario_id);
-- alter table usuario_rol add constraint fk_usuario_rol_rol foreign key(rol_id) references rol(rol_id);

-- CREACIÓN DE VISTAS

CREATE OR REPLACE VIEW v_libro_prestamo AS
SELECT libro.libro_id, COUNT(*) as conteo
FROM prestamo 
  INNER JOIN ejemplar ON prestamo.ejemplar_id = ejemplar.ejemplar_id
  INNER JOIN libro ON ejemplar.libro_id = libro.libro_id
GROUP BY libro.libro_id;

-- CREACIÓN DE TRIGGERS
CREATE OR REPLACE FUNCTION sp_timestamp_modificar()
RETURNS trigger AS
$BODY$
BEGIN
NEW.fecha_hora_modificacion := current_timestamp;
RETURN NEW;
END;
$BODY$
language plpgsql;

-- PARA CADA PRESTAMO QUE SE REALIZA SE DEBE ACTUALIZAR EL ESTADO DE UN EJEMPLAR
CREATE OR REPLACE FUNCTION sp_actualizar_prestamo()
RETURNS trigger AS
$BODY$
BEGIN
IF TG_OP = 'INSERT' THEN
  update ejemplar set estado = '0', prestamo_activo_id = NEW.prestamo_id where ejemplar_id = NEW.ejemplar_id;
END IF;

IF TG_OP = 'UPDATE' THEN
  IF NEW.fecha_entrega IS NOT NULL THEN
    update ejemplar set estado = '1', prestamo_activo_id = NULL where ejemplar_id = NEW.ejemplar_id;
  END IF;
END IF;

IF TG_OP = 'DELETE' THEN
  update ejemplar set estado = '1', prestamo_activo_id = NULL where ejemplar_id = OLD.ejemplar_id;
END IF;

RETURN NEW;
END;
$BODY$
language plpgsql;

CREATE OR REPLACE FUNCTION sp_actualizar_numero_subtema()
RETURNS trigger AS
$BODY$
DECLARE conteo_nuevo integer;
DECLARE conteo_antiguo integer;
BEGIN
IF TG_OP = 'INSERT' OR TG_OP = 'UPDATE' THEN
  IF NEW.tema_superior_id IS NOT NULL THEN
      SELECT INTO conteo_nuevo COUNT(tema_id) FROM tema WHERE tema.tema_superior_id = NEW.tema_superior_id;
      UPDATE tema SET cantidad_subtema = conteo_nuevo WHERE tema.tema_id = NEW.tema_superior_id;
  END IF;
END IF;
IF TG_OP = 'UPDATE' OR TG_OP = 'DELETE' THEN
  IF OLD.tema_superior_id IS NOT NULL THEN
      SELECT into conteo_antiguo COUNT(tema_id) FROM tema WHERE tema.tema_superior_id = OLD.tema_superior_id;
      UPDATE tema SET cantidad_subtema = conteo_antiguo WHERE tema.tema_id = OLD.tema_superior_id;
  END IF;
END IF;
RETURN NEW;
END;
$BODY$
language plpgsql;

CREATE OR REPLACE FUNCTION sp_actualizar_ultimo_login()
RETURNS trigger AS
$BODY$
BEGIN
  IF NEW.tipo = 'L' THEN
    UPDATE usuario SET evento_id = NEW.evento_id WHERE usuario_id = NEW.usuario_id;
  END IF;
  RETURN NEW;
END;
$BODY$
language plpgsql;

CREATE OR REPLACE FUNCTION sp_actualizar_numero_ejemplar()
RETURNS trigger AS
$BODY$
declare ejem_disponibles integer;
declare ejem_total integer;
BEGIN
IF TG_OP = 'INSERT' THEN
  -- select into ejem_total count(ejemplar_id) from ejemplar where libro_id = NEW.libro_id;
  -- select into ejem_disponibles count(ejemplar_id) from ejemplar where libro_id = NEW.libro_id and estado = '1';
  update libro set ejemplar_total = ejemplar_total + 1, ejemplar_disponible = ejemplar_disponible + 1 where libro_id = NEW.libro_id;
END IF;
IF TG_OP = 'DELETE' THEN
  IF OLD.estado = '1' THEN
    update libro set ejemplar_total = ejemplar_total - 1, ejemplar_disponible = ejemplar_disponible - 1 where libro_id = OLD.libro_id;
  ELSE
    update libro set ejemplar_total = ejemplar_total - 1 where libro_id = OLD.libro_id;
  END IF;  
END IF;
IF TG_OP = 'UPDATE' THEN
  IF NEW.libro_id <> OLD.libro_id THEN
    IF NEW.estado = '1' THEN
      update libro set ejemplar_total = ejemplar_total + 1, ejemplar_disponible = ejemplar_disponible + 1 where libro_id = NEW.libro_id;      
    ELSE
      update libro set ejemplar_total = ejemplar_total + 1 where libro_id = NEW.libro_id;      
    END IF;
    IF OLD.estado = '1' THEN
      update libro set ejemplar_total = ejemplar_total - 1, ejemplar_disponible = ejemplar_disponible - 1 where libro_id = OLD.libro_id;
    ELSE
      update libro set ejemplar_total = ejemplar_total - 1 where libro_id = OLD.libro_id;
    END IF;
  ELSE
    IF NEW.estado <> OLD.estado THEN
      IF NEW.estado = '1' THEN
        update libro set ejemplar_disponible = ejemplar_disponible + 1 where libro_id = NEW.libro_id;
      ELSE
        update libro set ejemplar_disponible = ejemplar_disponible - 1 where libro_id = OLD.libro_id;
      END IF;
    END IF;
  END IF;
END IF;
RETURN NEW;
END;
$BODY$
language plpgsql;

CREATE OR REPLACE FUNCTION sp_proteger_password()
RETURNS trigger AS
$BODY$
BEGIN
  IF (TG_OP = 'UPDATE' AND md5(NEW.password) <> OLD.password) OR TG_OP = 'INSERT' THEN
    NEW.password := md5(NEW.password);
  END IF;
RETURN NEW;
END;
$BODY$
language plpgsql;

CREATE TRIGGER tr_actualizar_prestamo
AFTER INSERT OR UPDATE OR DELETE
ON prestamo
FOR EACH ROW
EXECUTE PROCEDURE sp_actualizar_prestamo();

CREATE TRIGGER tr_numero_ejemplar
AFTER INSERT OR UPDATE OR DELETE
ON ejemplar
FOR EACH ROW
EXECUTE PROCEDURE sp_actualizar_numero_ejemplar();

CREATE TRIGGER tr_numero_subtema
AFTER INSERT OR UPDATE OR DELETE
ON tema
FOR EACH ROW
EXECUTE PROCEDURE sp_actualizar_numero_subtema();

CREATE TRIGGER tr_timestamp_modificar
BEFORE UPDATE
ON materia
FOR EACH ROW
EXECUTE PROCEDURE sp_timestamp_modificar();

CREATE TRIGGER tr_timestamp_modificar
BEFORE UPDATE
ON seccion
FOR EACH ROW
EXECUTE PROCEDURE sp_timestamp_modificar();

CREATE TRIGGER tr_timestamp_modificar
BEFORE UPDATE
ON tipo_libro
FOR EACH ROW
EXECUTE PROCEDURE sp_timestamp_modificar();

CREATE TRIGGER tr_timestamp_modificar
BEFORE UPDATE
ON editorial
FOR EACH ROW
EXECUTE PROCEDURE sp_timestamp_modificar();

CREATE TRIGGER tr_timestamp_modificar
BEFORE UPDATE
ON procedencia
FOR EACH ROW
EXECUTE PROCEDURE sp_timestamp_modificar();

CREATE TRIGGER tr_timestamp_modificar
BEFORE UPDATE
ON ejemplar
FOR EACH ROW
EXECUTE PROCEDURE sp_timestamp_modificar();

CREATE TRIGGER tr_timestamp_modificar
BEFORE UPDATE
ON prestamo
FOR EACH ROW
EXECUTE PROCEDURE sp_timestamp_modificar();

CREATE TRIGGER tr_timestamp_modificar
BEFORE UPDATE
ON libro_tema
FOR EACH ROW
EXECUTE PROCEDURE sp_timestamp_modificar();

CREATE TRIGGER tr_timestamp_modificar
BEFORE UPDATE
ON autor
FOR EACH ROW
EXECUTE PROCEDURE sp_timestamp_modificar();

CREATE TRIGGER tr_timestamp_modificar
BEFORE UPDATE
ON libro_autor
FOR EACH ROW
EXECUTE PROCEDURE sp_timestamp_modificar();

CREATE TRIGGER tr_timestamp_modificar
BEFORE UPDATE
ON persona
FOR EACH ROW
EXECUTE PROCEDURE sp_timestamp_modificar();

CREATE TRIGGER tr_timestamp_modificar
BEFORE UPDATE
ON usuario
FOR EACH ROW
EXECUTE PROCEDURE sp_timestamp_modificar();

CREATE TRIGGER tr_timestamp_modificar
BEFORE UPDATE
ON rol
FOR EACH ROW
EXECUTE PROCEDURE sp_timestamp_modificar();

-- CREATE TRIGGER tr_timestamp_modificar
-- BEFORE UPDATE
-- ON usuario_rol
-- FOR EACH ROW
-- EXECUTE PROCEDURE sp_timestamp_modificar();

CREATE TRIGGER tr_timestamp_modificar
BEFORE UPDATE
ON libro
FOR EACH ROW
EXECUTE PROCEDURE sp_timestamp_modificar();

CREATE TRIGGER tr_timestamp_modificar
BEFORE UPDATE
ON indice
FOR EACH ROW
EXECUTE PROCEDURE sp_timestamp_modificar();

CREATE TRIGGER tr_timestamp_modificar
BEFORE UPDATE
ON tema
FOR EACH ROW
EXECUTE PROCEDURE sp_timestamp_modificar();

CREATE TRIGGER tr_timestamp_modificar
BEFORE UPDATE
ON acceso
FOR EACH ROW
EXECUTE PROCEDURE sp_timestamp_modificar();

CREATE TRIGGER tr_timestamp_modificar
BEFORE UPDATE
ON rol_acceso
FOR EACH ROW
EXECUTE PROCEDURE sp_timestamp_modificar();

CREATE TRIGGER tr_actualizar_ultimo_login
AFTER INSERT
ON evento
FOR EACH ROW
EXECUTE PROCEDURE sp_actualizar_ultimo_login();

CREATE TRIGGER tr_proteger_password
BEFORE INSERT OR UPDATE
ON usuario
FOR EACH ROW
EXECUTE PROCEDURE sp_proteger_password();
-- PROCEDEREMOS CON LOS INSERTS
WITH mat_med AS(
INSERT INTO materia(
            nombre, descripcion)
    VALUES ('MEDICINA','TODO RELATIVO A LA MEDICINA') returning materia_id
)

INSERT INTO seccion(nombre,descripcion,materia_id)
(SELECT 'NEFROLOGÍA','REFERENTE AL RIÑÓN',mat_med.materia_id FROM mat_med
UNION
SELECT 'CARDIOLOGÍA','REFERENTE AL CORAZÓN',mat_med.materia_id FROM mat_med);


INSERT INTO editorial(nombre) VALUES('EDITORIAL PLANETA');
INSERT INTO editorial(nombre) VALUES('ELSEVIER ESPAÑA S.A.');
INSERT INTO procedencia(nombre,descripcion) VALUES('COMPRA','COMPRA PARA ACTUALIZAR TEXTOS');
INSERT INTO procedencia(nombre,descripcion) VALUES('DONACIÓN','DONACIÓN');
INSERT INTO autor(nombres,paterno,tipo_autor) VALUES('ROBERT O.','BONOW','0');
WITH tema_estsuperiores AS (
    INSERT INTO tema(nombre,descripcion) VALUES('ESTUDIOS SUPERIORES','LIBROS PARA ESTUDIOS UNIVERSITARIOS') returning tema_id
)
INSERT INTO tema(nombre,descripcion,tema_superior_id) SELECT 'TRATADOS DE MEDICINA','LIBROS SOBRE MEDICINA',tema_estsuperiores.tema_id FROM tema_estsuperiores;

INSERT INTO tipo_libro(nombre) VALUES('LIBRO');
INSERT INTO tipo_libro(nombre) VALUEs('REVISTA');

INSERT INTO persona(nombres, paterno, materno, dni, email) VALUES ('FRANCIS PAUL','ESQUIVEL','CUENCA','46557081','fesquivelc@gmail.com');
INSERT INTO persona(nombres, paterno, materno, dni, email) VALUES ('WALTER','ESQUIVEL','CUENCA','47170982','drago_648@hotmail.com');
INSERT INTO persona(nombres, paterno, materno, dni, email) VALUES ('ALDO MISAEL','JAMANCA','CHAVEZ','12345678','aldo_mjc@hotmail.com');
INSERT INTO persona(nombres, paterno, materno, dni, email) VALUES ('JUAN CARLOS (PACO)','QUISPE','DÁVILA','34567891','jcgls.nba@gmail.com');

INSERT INTO acceso(nombre, objeto, descripcion) VALUES ('AUTORES','com.biosis.sgb.vistas.AutorView','GESTIÓN DE LA INFORMACIÓN DE AUTORES');
INSERT INTO acceso(nombre, objeto, descripcion) VALUES ('CONSULTAS','com.biosis.sgb.vistas.ConsultaView','REALIZACIÓN DE CONSULTAS DE MATERIAL BIBLIOGRÁFICO');
INSERT INTO acceso(nombre, objeto, descripcion) VALUES ('EDITORIALES','com.biosis.sgb.vistas.EditorialView','GESTIÓN DE LA INFORMACIÓN DE EDITORIALES');
INSERT INTO acceso(nombre, objeto, descripcion) VALUES ('EJEMPLARES','com.biosis.sgb.vistas.EjemplarView','GESTIÓN DE LA INFORMACIÓN DE EJEMPLARES');
INSERT INTO acceso(nombre, objeto, descripcion) VALUES ('LIBRO','com.biosis.sgb.vistas.LibroView','GESTIÓN DE LA INFORMACIÓN DE LIBROS');
INSERT INTO acceso(nombre, objeto, descripcion) VALUES ('MATERIAS Y SECCIONES','com.biosis.sgb.vistas.MateriaSeccionView','GESTIÓN DE LA INFORMACIÓN DE MATERIAS Y SECCIONES');
INSERT INTO acceso(nombre, objeto, descripcion) VALUES ('PERSONAS','com.biosis.sgb.vistas.PersonaView','GESTIÓN DE LA INFORMACIÓN DE PERSONAS');
INSERT INTO acceso(nombre, objeto, descripcion) VALUES ('PRESTAMOS','com.biosis.sgb.vistas.PrestamoView','GESTIÓN DE PRÉSTAMOS DE MATERIAL BIBLIOGRÁFICO');
INSERT INTO acceso(nombre, objeto, descripcion) VALUES ('REPORTE DE EJEMPLARES','com.biosis.sgb.vistas.ReporteEjemplarView','CAPACIDAD DE GENERAR REPORTES DE LOS EJEMPLARES');
INSERT INTO acceso(nombre, objeto, descripcion) VALUES ('TEMAS','com.biosis.sgb.vistas.TemaView','GESTIÓN DE LA INFORMACIÓN DE TEMAS Y SUBTEMAS');
INSERT INTO acceso(nombre, objeto, descripcion) VALUES ('TIPO DE LIBRO','com.biosis.sgb.vistas.TipoLibroView','GESTIÓN DE LA INFORMACIÓN DE TIPOS DE LIBRO');

WITH rol_admin AS (
  INSERT INTO rol(nombre,activo) VALUES('ADMINISTRADOR','1') returning rol_id
) 
INSERT INTO usuario(login, password, cambiar_password, rol_id, activo)
SELECT 'admin',md5('sgbmoquegua'),'0',rol_id,'1' FROM rol_admin;
