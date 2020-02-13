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

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String nacionalidade;

    @ManyToMany(mappedBy = "participantes", cascade = CascadeType.PERSIST)
    private Set<Album> albuns = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "autores", cascade = CascadeType.PERSIST)
    private Set<Musica> musicasComoAutor = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "interpretes", cascade = CascadeType.PERSIST)
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
}
