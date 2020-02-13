CREATE TABLE autor_musica (
      artista_id INT NOT NULL,
      musica_id INT(11) NOT NULL,
      PRIMARY KEY (artista_id, musica_id),
      INDEX fk_autor_has_musica_musica1_idx (musica_id ASC),
      INDEX fk_autor_has_musica_autor_idx (artista_id ASC)
) engine=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO autor_musica (artista_id, musica_id) VALUES ('1', '1');
INSERT INTO autor_musica (artista_id, musica_id) VALUES ('1', '2');
INSERT INTO autor_musica (artista_id, musica_id) VALUES ('1', '3');
INSERT INTO autor_musica (artista_id, musica_id) VALUES ('1', '4');