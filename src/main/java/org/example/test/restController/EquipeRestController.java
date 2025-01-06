package org.example.test.restController;

import lombok.AllArgsConstructor;
import org.example.test.entity.Equipe;
import org.example.test.service.interfaces.IEquipeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EquipeRestController {

    IEquipeService equipeService;

    @PostMapping(path = "Equipe/add")
    Equipe ajouterEquipeEtJoueurs (@RequestBody Equipe equipe){
        return equipeService.ajouterEquipeEtJoueurs(equipe);
    }


}
