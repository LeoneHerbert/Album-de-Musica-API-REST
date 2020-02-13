package br.com.herbertleone.albumdemusica.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "artista")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(nullable = false)
    private String nacionalidade;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "artista_album",
            joinColumns = {@JoinColumn(name = "artista_id")},
            inverseJoinColumns = {@JoinColumn(name = "album_id")}
    )
    private Set<Album> albuns = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "autor_musica",
            joinColumns = {@JoinColumn(name = "artista_id")},
            inverseJoinColumns = {@JoinColumn(name = "musica_id")}
    )
    private Set<Musica> musicasComoAutor = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "interprete_musica",
            joinColumns = {@JoinColumn(name = "artista_id")},
            inverseJoinColumns = {@JoinColumn(name = "musica_id")}
    )
    private Set<Musica> musicasInterpretadas = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Set<Album> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(Set<Album> albuns) {
        this.albuns = albuns;
    }

    public void setMusicasComoAutor(Set<Musica> musicasComoAutor) {
        this.musicasComoAutor = musicasComoAutor;
    }

    public void setMusicasInterpretadas(Set<Musica> musicasInterpretadas) {
        this.musicasInterpretadas = musicasInterpretadas;
    }
}
