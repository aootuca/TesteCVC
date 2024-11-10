INSERT INTO cliente(id, nome, email, usuario_criador, usuario_alteracao, data_criada, data_alterada) VALUES(NEXTVAL('cliente_id_seq'), 'John Snow', 'snow@gmail.com', null, null, CURRENT_TIMESTAMP, null);
INSERT INTO cliente(id, nome, email, usuario_criador, usuario_alteracao, data_criada, data_alterada) VALUES(NEXTVAL('cliente_id_seq'), 'Big Bob', 'bigbob@yahoo.com', null, null, CURRENT_TIMESTAMP, null);
INSERT INTO cliente(id, nome, email, usuario_criador, usuario_alteracao, data_criada, data_alterada) VALUES(NEXTVAL('cliente_id_seq'), 'Tony Cerezo', 't_cerezo@terra.com.br', null, null, CURRENT_TIMESTAMP, null);

INSERT INTO endereco(id, rua, cidade, estado) VALUES(NEXTVAL('endereco_id_seq'), '8809 Barros Travessa', 'Mossamedes', 'MG');
INSERT INTO endereco(id, rua, cidade, estado) VALUES(NEXTVAL('endereco_id_seq'), '267 Isabella Travessa', 'Bauru', 'RJ');
INSERT INTO endereco(id, rua, cidade, estado) VALUES(NEXTVAL('endereco_id_seq'), '5716 Mercia Rua', 'Bom Jardim', 'MA');

INSERT INTO usuario(id, usuario, password) VALUES(1, 'teste', 'teste')