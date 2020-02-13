package br.com.herbertleone.albumdemusica.controller;

import br.com.herbertleone.albumdemusica.controller.event.HeaderLocationEvento;
import br.com.herbertleone.albumdemusica.model.Album;
import br.com.herbertleone.albumdemusica.service.AlbumService;
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
@RequestMapping("/albuns")
public class AlbumController {

    @Autowired
    private ApplicationEventPublisher publisher;

    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping
    public ResponseEntity<Album> cria(@Validated @RequestBody Album album, HttpServletResponse response) {
        Album albumSalvo = albumService.salva(album );

        publisher.publishEvent(new HeaderLocationEvento(this, response, albumSalvo.getId()) );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(albumSalvo );
    }

    @GetMapping
    public List<Album> todos() {
        return albumService.todos();
    }

    @GetMapping("/{id}")
    public Album buscaPor(@PathVariable Integer id) {
        return albumService.buscaPor(id );
    }

    @GetMapping("/{nome}")
    public Optional<Album> buscaPor(@PathVariable String nome) {
        return albumService.buscaPor(nome );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Album> atualiza(@PathVariable Integer id, @Validated @RequestBody Album album) {
        Album albumManager = albumService.atualiza(album, id );
        return ResponseEntity.ok(albumManager );
    }

}
