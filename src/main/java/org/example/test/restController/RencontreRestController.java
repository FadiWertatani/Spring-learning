package org.example.test.restController;

import lombok.AllArgsConstructor;
import org.example.test.entity.Arbitre;
import org.example.test.entity.Rencontre;
import org.example.test.service.interfaces.IRencontreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class RencontreRestController {

    IRencontreService rencontreService;

    @PostMapping(path = "Rencontre/{e1}x{e2}")
    Rencontre ajouterRencontreEtAffecterEquipes(@RequestBody Rencontre rencontre, @PathVariable Long e1, @PathVariable Long e2){
        return rencontreService.ajouterRencontreEtAffecterEquipes(rencontre, e1, e2);
    }

    @PostMapping(path = "Rencontre/affecterArbitre/{nom}x{prenom}x{idR}")
    void affecterArbitreARencontre(@PathVariable String nom,@PathVariable String prenom,@PathVariable Long idR) throws Exception {
        rencontreService.affecterArbitreARencontre(nom, prenom, idR);
    }

    @PostMapping(path = "Rencontre/incrementerNbreBut/{id}")
    void incrementerNbreBut(@PathVariable Long id){
        rencontreService.incrementerNbreBut(id);
    }

    @GetMapping("/EquipeArbitre/{idEquipe}")
    List<Arbitre> recupererArbitresDUneEquipe(@PathVariable Long idEquipe){
        return rencontreService.recupererArbitresDUneEquipe(idEquipe);
    }


}
