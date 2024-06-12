package com.luca.monopoly.repository;

import com.luca.monopoly.domain.Segnalini;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaGiocatoreRepository extends JpaRepository<JpaGiocatore, Integer> {

    JpaGiocatore findBySegnalino(Segnalini segnalini);

}
