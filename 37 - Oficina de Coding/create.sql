create table dentista (id integer not null auto_increment, atendeconvenio bit not null, cro integer, email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB;
create table endereco (id integer not null auto_increment, bairro varchar(255), cep varchar(255), cidade varchar(255), estado varchar(255), numero varchar(255), rua varchar(255), primary key (id)) engine=InnoDB;
create table paciente (id integer not null auto_increment, cpf varchar(255), datacadastro date, email varchar(255), nome varchar(255), primary key (id)) engine=InnoDB;
create table paciente_endereco (paciente_id integer not null, endereco_id integer not null, primary key (paciente_id, endereco_id)) engine=InnoDB;
alter table paciente_endereco add constraint FKnle8gx9uisd4sfjtb7poblg15 foreign key (endereco_id) references endereco (id);
alter table paciente_endereco add constraint FKkwh3sxrgay2yq6hythkf2q6vn foreign key (paciente_id) references paciente (id);
INSERT INTO dentista (nome, email, cro, atendeconvenio) VALUES ('Paola Santos', 'p.santos@gmail.com', 21456, TRUE);
INSERT INTO dentista (nome, email, cro, atendeconvenio) VALUES ('Monique Albuquerque', 'albuquerquedentista@gmail.com', 22563, FALSE);
INSERT INTO dentista (nome, email, cro, atendeconvenio) VALUES ('Octávio Martinez', 'octaviomtnz@gmail.com', 21541, TRUE);
INSERT INTO paciente (nome, email, cpf, datacadastro) VALUES ('Lewis Hamilton', 'hamiltonf1@gmail.com', '321654789-52', '2022-08-30');
INSERT INTO paciente (nome, email, cpf, datacadastro) VALUES ('Charles Leclerc', 'leclerc@gmail.com', '255633021-54', '2022-08-30');
INSERT INTO paciente (nome, email, cpf, datacadastro) VALUES ('Fernando Alonso', 'alonso-piloto@gmail.com', '541144787-95', '2022-09-01');
INSERT INTO endereco (rua, numero, bairro, cidade, cep, estado) VALUES ('Rua Farroupilha', '2154', 'Centro', 'Porto Alegre', '90600-410', 'RS');
INSERT INTO endereco (rua, numero, bairro, cidade, cep, estado) VALUES ('Rua Santos Dumont', '255', 'Cidade Baixa', 'Porto Alegre', '95555-110', 'RS');
INSERT INTO endereco (rua, numero, bairro, cidade, cep, estado) VALUES ('Servidão Almeida', '52', 'Centro', 'Florianópolis', '88020-219', 'SC');
INSERT INTO paciente_endereco (paciente_id, endereco_id) VALUES (1, 3);
INSERT INTO paciente_endereco (paciente_id, endereco_id) VALUES (2, 2);
INSERT INTO paciente_endereco (paciente_id, endereco_id) VALUES (3, 1);
INSERT INTO paciente_endereco (paciente_id, endereco_id) VALUES (2, 3);
INSERT INTO paciente_endereco (paciente_id, endereco_id) VALUES (3, 2);
INSERT INTO paciente_endereco (paciente_id, endereco_id) VALUES (3, 3);
