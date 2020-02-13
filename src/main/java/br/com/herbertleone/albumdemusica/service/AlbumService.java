package br.com.herbertleone.albumdemusica.service;


import br.com.herbertleone.albumdemusica.model.Album;
import br.com.herbertleone.albumdemusica.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    private final GenericoService<Album> genericoService;

    @Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
        this.genericoService = new GenericoService<Album>(albumRepository);
    }

    @Transactional
    public Album salva(Album album ) {
        return this.genericoService.salva(album);
    }

    @Transactional(readOnly = true)
    public Album buscaPor(Integer id) {
        return this.genericoService.buscaPor(id );
    }

    @Transactional(readOnly = true)
    public Optional<Album> buscaPor(String nome) {
        return Optional.ofNullable( albumRepository.findByNome(nome ) );
    }

    @Transactional(readOnly = true)
    public List<Album> todos() {
        return genericoService.todos();
    }

    @Transactional
    public Album atualiza(Album album, Integer id) {
        return this.genericoService.atualiza(album, id);
    }

    @Transactional
    public void excluir(Integer id) {
        this.genericoService.excluirPor(id );
    }
}
