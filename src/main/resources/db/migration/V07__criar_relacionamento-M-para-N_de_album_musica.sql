CREATE TABLE album_musica (
      album_id INT NOT NULL,
      musica_id INT(11) NOT NULL,
      PRIMARY KEY (album_id, musica_id),
      INDEX fk_album_has_musica_musica1_idx (album_id ASC),
      INDEX fk_album_has_musica_album_idx (musica_id ASC)
) engine=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO album_musica (album_id, musica_id) VALUES ('1', '1');
INSERT INTO album_musica (album_id, musica_id) VALUES ('2', '2');
INSERT INTO album_musica (album_id, musica_id) VALUES ('2', '3');
INSERT INTO album_musica (album_id, musica_id) VALUES ('3', '4');