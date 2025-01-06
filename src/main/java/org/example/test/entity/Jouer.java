package org.example.test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.test.constants.Niveau;
import org.example.test.constants.Poste;

@Entity
@Getter
@Setter
public class Jouer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String nom;

    @Column
    private String prenom;

    @Enumerated(EnumType.STRING)
    private Poste poste;

    @Column
    private int num_maillot;

    @ManyToOne
    private Equipe equipe;

}
