package org.example.test.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
public class Equipe {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String nomEquipe;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateCreation;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipe")
    private Set<Jouer> jouers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipeDomicile")
    private Set<Rencontre> rencontresDomicile;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipeExterieur")
    private Set<Rencontre> rencontresExterieur;

}
