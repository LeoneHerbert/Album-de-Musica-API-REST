package br.com.herbertleone.albumdemusica.controller;

import br.com.herbertleone.albumdemusica.controller.event.HeaderLocationEvento;
import br.com.herbertleone.albumdemusica.model.Musica;
import br.com.herbertleone.albumdemusica.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private ApplicationEventPublisher publisher;

    private final MusicaService musicaService;

    @Autowired
    public MusicaController(MusicaService musicaService) {
        this.musicaService = musicaService;
    }

    @PostMapping
    public ResponseEntity<Musica> cria(@Validated @RequestBody Musica musica, HttpServletResponse response) {
        Musica musicaSalvo = musicaService.salva(musica );

        publisher.publishEvent(new HeaderLocationEvento(this, response, musicaSalvo.getId()) );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(musicaSalvo );
    }

    @GetMapping
    public List<Musica> todos() {
        return musicaService.todos();
    }

    @GetMapping("/{id}")
    public Musica buscaPor(@PathVariable Integer id) {
        return musicaService.buscaPor(id );
    }

    @GetMapping("/{nome}")
    public Optional<Musica> buscaPor(@PathVariable String nome) {
        return musicaService.buscaPor(nome );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Musica> atualiza(@PathVariable Integer id, @Validated @RequestBody Musica musica) {
        Musica musicaManager = musicaService.atualiza(musica, id );
        return ResponseEntity.ok(musicaManager );
    }

}

