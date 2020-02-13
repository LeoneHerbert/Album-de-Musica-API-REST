package br.com.herbertleone.albumdemusica.repository;

import br.com.herbertleone.albumdemusica.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<Artista, Integer> {

    Artista findByNome(String nome);

}
