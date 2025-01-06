package org.example.test.repository;

import org.example.test.entity.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipeRepo extends JpaRepository<Equipe, Long> {
    Equipe findEquipeById(Long id);
}
