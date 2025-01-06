package org.example.test.service.implementation;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.test.entity.Arbitre;
import org.example.test.entity.Equipe;
import org.example.test.entity.Rencontre;
import org.example.test.repository.IArbitreRepo;
import org.example.test.repository.IEquipeRepo;
import org.example.test.repository.IRencontreRepo;
import org.example.test.service.interfaces.IRencontreService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class RencontreImpl implements IRencontreService {
    IRencontreRepo rencontreRepo;
    IEquipeRepo equipeRepo;
    IArbitreRepo arbitreRepo;
    @Override
    public Rencontre ajouterRencontreEtAffecterEquipes(Rencontre rencontre, Long idEquipe1, Long idEquipe2) {

        Equipe equipe1 = equipeRepo.findEquipeById(idEquipe1);
        Equipe equipe2 = equipeRepo.findEquipeById(idEquipe2);

        rencontre.setNbre_but(0);
        rencontre.setEquipeDomicile(equipe1);
        rencontre.setEquipeExterieur(equipe2);


        return rencontreRepo.save(rencontre);
    }

    @Override
    public void incrementerNbreBut(Long idRencontre){
        Rencontre rencontre = rencontreRepo.findRencontreById(idRencontre);
        int nbr = rencontre.getNbre_but();
        nbr++;
        rencontre.setNbre_but(nbr);
        rencontreRepo.save(rencontre);
    }

    @Override
    public void affecterArbitreARencontre(String nom, String prenom, Long idR) throws Exception {
        Arbitre arbitre = arbitreRepo.findArbitreByNomAndPrenom(nom, prenom);
        Rencontre rencontre = rencontreRepo.findRencontreById(idR);

        if(arbitre.getNiveau().equals(rencontre.getNiveau())){
            rencontre.setArbitre(arbitre);
            rencontreRepo.save(rencontre);
        }else {
            throw new Exception("Exception déclanchée");
        }
    }

    @Override
    public List<Arbitre> recupererArbitresDUneEquipe(Long idEquipe) {
        return rencontreRepo.recupererArbitresDUneEquipe(idEquipe);
    }


    @Scheduled(cron = "0 0 8 * * *")
    void rencontreDeDateSys(){
        LocalDate localDate = LocalDate.now();
        List<Rencontre> rencontres = rencontreRepo.findRencontresByDateMatch(localDate);
        if(rencontres.isEmpty()){
//            log.info("Aucune rencontre prévue pour la date : {}", localDate);
            log.info("Aucune rencontre prévue pour aujourd'hui");
        }else {
            log.info("*** Les rencontres d'aujourd'hui ***");
            for (Rencontre rencontre : rencontres){
                log.info(rencontre.toString());
            }
        }
    }


}
