package br.com.herbertleone.albumdemusica.service;

import br.com.herbertleone.albumdemusica.model.Musica;
import br.com.herbertleone.albumdemusica.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MusicaService {

    private final MusicaRepository musicaRepository;

    private final GenericoService<Musica> genericoService;

    @Autowired
    public MusicaService(MusicaRepository musicaRepository) {
        this.musicaRepository = musicaRepository;
        this.genericoService = new GenericoService<Musica>(musicaRepository);
    }

    @Transactional
    public Musica salva(Musica musica ) {
        return this.genericoService.salva(musica);
    }

    @Transactional(readOnly = true)
    public Musica buscaPor(Integer id) {
        return this.genericoService.buscaPor(id );
    }

    @Transactional(readOnly = true)
    public Optional<Musica> buscaPor(String nome) {
        return Optional.ofNullable( musicaRepository.findByNome(nome ) );
    }

    @Transactional(readOnly = true)
    public List<Musica> todos() {
        return genericoService.todos();
    }

    @Transactional
    public Musica atualiza(Musica musica, Integer id) {
        return this.genericoService.atualiza(musica, id);
    }

    @Transactional
    public void excluir(Integer id) {
        this.genericoService.excluirPor(id );
    }
}
