CREATE TABLE album (
             id INT NOT NULL AUTO_INCREMENT,
             nome VARCHAR(255) NOT NULL,
             ano INT(4) NOT NULL ,
             PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO album (nome, ano) VALUES ('Bad', 1987);
INSERT INTO album (nome, ano) VALUES ('Thriller', 1982);
INSERT INTO album (nome, ano) VALUES ('We are the world', 1985);