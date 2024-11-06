INSERT INTO cliente(id, nome, email) VALUES(NEXTVAL('cliente_id_seq'), 'John Snow', 'snow@gmail.com');
INSERT INTO cliente(id, nome, email) VALUES(NEXTVAL('cliente_id_seq'), 'Big Bob', 'bigbob@yahoo.com');
INSERT INTO cliente(id, nome, email) VALUES(NEXTVAL('cliente_id_seq'), 'Tony Cerezo', 't_cerezo@terra.com.br');

INSERT INTO endereco(id, rua, cidade, estado) VALUES(NEXTVAL('endereco_id_seq'), '8809 Barros Travessa', 'Mossamedes', 'MG');
INSERT INTO endereco(id, rua, cidade, estado) VALUES(NEXTVAL('endereco_id_seq'), '267 Isabella Travessa', 'Bauru', 'RJ');
INSERT INTO endereco(id, rua, cidade, estado) VALUES(NEXTVAL('endereco_id_seq'), '5716 Mercia Rua', 'Bom Jardim', 'MA');