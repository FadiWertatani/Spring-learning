package org.example.test.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.test.constants.Niveau;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Rencontre {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateMatch;

    @Column
    private int nbre_but;

    @Column
    private String nomStade;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    @ManyToOne
    private Arbitre arbitre;

    @ManyToOne
    private Equipe equipeDomicile;

    @ManyToOne
    private Equipe equipeExterieur;

}
