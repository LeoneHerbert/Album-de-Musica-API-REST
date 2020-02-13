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

    @ManyToMany(mappedBy = "musicas", cascade = CascadeType.PERSIST)
    private Set<Album> albuns = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "musicasInterpretadas", cascade = CascadeType.PERSIST)
    private Set<Artista> interpretes = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "musicasComoAutor", cascade = CascadeType.PERSIST)
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

    public void setInterpretes(Set<Artista> interpretes) {
        this.interpretes = interpretes;
    }

    public void setAutores(Set<Artista> autores) {
        this.autores = autores;
    }

    public void setAlbuns(Set<Album> albuns) {
        this.albuns = albuns;
    }
}
