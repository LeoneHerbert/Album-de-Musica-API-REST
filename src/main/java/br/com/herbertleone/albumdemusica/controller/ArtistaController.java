package br.com.herbertleone.albumdemusica.controller;

import br.com.herbertleone.albumdemusica.controller.event.HeaderLocationEvento;
import br.com.herbertleone.albumdemusica.model.Artista;
import br.com.herbertleone.albumdemusica.service.ArtistaService;
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
@RequestMapping("/artistas")
public class ArtistaController {

    @Autowired
    private ApplicationEventPublisher publisher;

    private final ArtistaService artistaService;

    @Autowired
    public ArtistaController(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    @PostMapping
    public ResponseEntity<Artista> cria(@Validated @RequestBody Artista artista, HttpServletResponse response) {
        Artista artistaSalvo = artistaService.salva(artista );

        publisher.publishEvent(new HeaderLocationEvento(this, response, artistaSalvo.getId()) );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(artistaSalvo );
    }

    @GetMapping
    public List<Artista> todos() {
        return artistaService.todos();
    }

    @GetMapping("/{id}")
    public Artista buscaPor(@PathVariable Integer id) {
        return artistaService.buscaPor(id );
    }

    @GetMapping("/{nome}")
    public Optional<Artista> buscaPor(@PathVariable String nome) {
        return artistaService.buscaPor(nome );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artista> atualiza(@PathVariable Integer id, @Validated @RequestBody Artista artista ) {
        Artista artistaManager = artistaService.atualiza(artista, id );
        return ResponseEntity.ok(artistaManager );
    }

}

