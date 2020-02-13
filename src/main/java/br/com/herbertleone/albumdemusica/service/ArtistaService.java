package br.com.herbertleone.albumdemusica.service;


import br.com.herbertleone.albumdemusica.model.Artista;
import br.com.herbertleone.albumdemusica.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService {

    private final ArtistaRepository artistaRepository;

    private final GenericoService<Artista> genericoService;

    @Autowired
    public ArtistaService(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
        this.genericoService = new GenericoService<Artista>(artistaRepository);
    }

    @Transactional
    public Artista salva(Artista artista ) {
        return this.genericoService.salva(artista);
    }

    @Transactional(readOnly = true)
    public Artista buscaPor(Integer id) {
        return this.genericoService.buscaPor(id );
    }

    @Transactional(readOnly = true)
    public Optional<Artista> buscaPor(String nome) {
        return Optional.ofNullable( artistaRepository.findByNome(nome ) );
    }

    @Transactional(readOnly = true)
    public List<Artista> todos() {
        return genericoService.todos();
    }

    @Transactional
    public Artista atualiza(Artista artista, Integer id) {
        return this.genericoService.atualiza(artista, id);
    }

    @Transactional
    public void excluir(Integer id) {
        this.genericoService.excluirPor(id );
    }
}
