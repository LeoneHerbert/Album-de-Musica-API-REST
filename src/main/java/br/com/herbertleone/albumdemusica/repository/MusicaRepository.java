package br.com.herbertleone.albumdemusica.repository;

import br.com.herbertleone.albumdemusica.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MusicaRepository extends JpaRepository<Musica, Integer> {

    Musica findByNome(String nome);

}
