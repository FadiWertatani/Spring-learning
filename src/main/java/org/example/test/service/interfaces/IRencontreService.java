package org.example.test.service.interfaces;

import org.example.test.entity.Arbitre;
import org.example.test.entity.Rencontre;

import java.util.List;

public interface IRencontreService {

    Rencontre ajouterRencontreEtAffecterEquipes(Rencontre rencontre, Long idEquipe1, Long idEquipe2);

    void affecterArbitreARencontre (String nom, String prenom, Long idR) throws Exception;

    void incrementerNbreBut(Long idRencontre);

    List<Arbitre> recupererArbitresDUneEquipe(Long idEquipe);

}
