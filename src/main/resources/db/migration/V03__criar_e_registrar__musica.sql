CREATE TABLE musica (
             id INT NOT NULL AUTO_INCREMENT,
             nome VARCHAR(255) NOT NULL,
             duracao INT(4) NOT NULL ,
             PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO musica (nome, duracao) VALUES ('Smooth Criminal', 250);
INSERT INTO musica (nome, duracao) VALUES ('Billie Jean', 300);
INSERT INTO musica (nome, duracao) VALUES ('Beat It', 240);
INSERT INTO musica (nome, duracao) VALUES ('We are the world', 390);