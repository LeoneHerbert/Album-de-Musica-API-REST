CREATE TABLE artista (
             id INT NOT NULL AUTO_INCREMENT,
             nome VARCHAR(255) NOT NULL,
             nacionalidade VARCHAR(64) NOT NULL,
             PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO artista (nome, nacionalidade) VALUES ('Michael Jackson', 'USA');
INSERT INTO artista (nome, nacionalidade) VALUES ('Ray Charles', 'USA');