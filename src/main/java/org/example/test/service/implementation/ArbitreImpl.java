package org.example.test.service.implementation;

import lombok.AllArgsConstructor;
import org.example.test.entity.Arbitre;
import org.example.test.repository.IArbitreRepo;
import org.example.test.service.interfaces.IArbitreService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ArbitreImpl implements IArbitreService {
    IArbitreRepo arbitreRepo;

    @Override
    public Arbitre ajouterArbitre(Arbitre arbitre) {
        return arbitreRepo.save(arbitre);
    }
}
