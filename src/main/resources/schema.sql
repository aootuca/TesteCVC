DROP TABLE IF EXISTS cliente;

CREATE TABLE cliente (
	id INTEGER,
    nome varchar(50),
    email varchar(50),
    usuario_criador varchar(50),
    usuario_alteracao varchar(50),
    data_criada TIMESTAMP,
    data_alterada TIMESTAMP,
    constraint pk_cliente primary key(id)
);

DROP SEQUENCE IF EXISTS cliente_id_seq;

CREATE SEQUENCE cliente_id_seq AS INTEGER
START WITH 1
MINVALUE 1
MAXVALUE 9999
INCREMENT BY 1;

DROP TABLE IF EXISTS endereco;

CREATE TABLE endereco (
	id INTEGER,
    rua varchar(50),
    cidade varchar(50),
    estado char(2),
    constraint pk_endereco primary key(id),
    constraint fk_cliente foreign key(id) references cliente(id)
);

DROP SEQUENCE IF EXISTS endereco_id_seq;

CREATE SEQUENCE endereco_id_seq AS INTEGER
START WITH 1
MINVALUE 1
MAXVALUE 9999
INCREMENT BY 1;


