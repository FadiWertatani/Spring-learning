package org.example.test.service.implementation;

import lombok.AllArgsConstructor;
import org.example.test.entity.Equipe;
import org.example.test.repository.IEquipeRepo;
import org.example.test.service.interfaces.IEquipeService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EquipeImpl implements IEquipeService {

    IEquipeRepo equipeRepo;

    @Override
    public Equipe ajouterEquipeEtJoueurs(Equipe equipe) {
        return equipeRepo.save(equipe);
    }
}
