CREATE TABLE interprete_musica (
      artista_id INT NOT NULL,
      musica_id INT(11) NOT NULL,
      PRIMARY KEY (artista_id, musica_id),
      INDEX fk_interprete_has_musica_musica1_idx (musica_id ASC),
      INDEX fk_interprete_has_musica_interprete_idx (artista_id ASC)
) engine=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO interprete_musica (artista_id, musica_id) VALUES ('1', '1');
INSERT INTO interprete_musica (artista_id, musica_id) VALUES ('1', '2');
INSERT INTO interprete_musica (artista_id, musica_id) VALUES ('1', '3');
INSERT INTO interprete_musica (artista_id, musica_id) VALUES ('1', '4');
INSERT INTO interprete_musica (artista_id, musica_id) VALUES ('2', '4');