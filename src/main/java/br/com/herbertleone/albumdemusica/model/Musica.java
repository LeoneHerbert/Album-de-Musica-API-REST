package br.com.herbertleone.albumdemusica.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "musica")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer duracao;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "album_musica",
            joinColumns = {@JoinColumn(name = "musica_id")},
            inverseJoinColumns = {@JoinColumn(name = "album_id")}
    )
    private Set<Album> albuns = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "interprete_musica",
            joinColumns = {@JoinColumn(name = "musica_id")},
            inverseJoinColumns = {@JoinColumn(name = "artista_id")}
    )
    private Set<Artista> interpretes = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "autor_musica",
            joinColumns = {@JoinColumn(name = "musica_id")},
            inverseJoinColumns = {@JoinColumn(name = "artista_id")}
    )
    private Set<Artista> autores = new LinkedHashSet<>();

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

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Set<Artista> getAutores() {
        return autores;
    }

    public void setAutores(Set<Artista> autores) {
        this.autores = autores;
    }

    public Set<Artista> getInterpretes() {
        return interpretes;
    }

    public void setInterpretes(Set<Artista> interpretes) {
        this.interpretes = interpretes;
    }

    public Set<Album> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(Set<Album> albuns) {
        this.albuns = albuns;
    }
}
