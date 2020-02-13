package br.com.herbertleone.albumdemusica.repository;

import br.com.herbertleone.albumdemusica.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {

    Album findByNome(String nome);

}
