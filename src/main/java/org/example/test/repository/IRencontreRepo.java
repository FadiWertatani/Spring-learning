package org.example.test.repository;

import org.example.test.entity.Arbitre;
import org.example.test.entity.Rencontre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IRencontreRepo extends JpaRepository<Rencontre, Long> {

    Rencontre findRencontreById(Long id);

    List<Rencontre> findRencontresByDateMatch(LocalDate localDate);

    @Query("SELECT DISTINCT a FROM Arbitre a " +
            "JOIN a.rencontres r " +
            "WHERE r.equipeDomicile.id = :idEquipe OR r.equipeExterieur.id = :idEquipe")
    List<Arbitre> recupererArbitresDUneEquipe(Long idEquipe);

}
