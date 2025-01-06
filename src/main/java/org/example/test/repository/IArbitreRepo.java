package org.example.test.repository;

import org.apache.catalina.User;
import org.example.test.entity.Arbitre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArbitreRepo extends JpaRepository<Arbitre, Long> {

    Arbitre findArbitreByNomAndPrenom(String nom, String prenom);

}
