package org.example.test.restController;

import lombok.AllArgsConstructor;
import org.example.test.entity.Arbitre;
import org.example.test.service.interfaces.IArbitreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @AllArgsConstructor
public class ArbitreRestController {

    IArbitreService arbitreService;

    @PostMapping(path = "arbitre/add")
    Arbitre ajouterArbitre(@RequestBody Arbitre arbitre){
        return arbitreService.ajouterArbitre(arbitre);
    }

}
