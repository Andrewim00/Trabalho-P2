package application.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "jogos")
@Getter
@Setter
public class Jogo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "id_genero",nullable = false)
    private Genero genero;

    @Column(nullable = false)
    private String titulo;

    @ManyToMany
    @JoinTable(name = "jogos_possuem_generos",
        joinColumns = @JoinColumn(name = "id_jogo"),
        inverseJoinColumns = @JoinColumn(name = "id_genero")
    )
    private Set<> generos = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "jogos_possuem_generos",
        joinColumns = @JoinColumn(name = "id_jogo"),
        inverseJoinColumns = @JoinColumn(name = "id_plataforma")
    )
    private Set<> plataformas = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "id_modo", nullable = false)
    private long modo;

}
