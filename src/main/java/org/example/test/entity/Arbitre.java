package org.example.test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.test.constants.Niveau;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Arbitre {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String nom;

    @Column
    private String prenom;

    @Column
    private String nationalite;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "arbitre")
    private Set<Rencontre> rencontres;

}
