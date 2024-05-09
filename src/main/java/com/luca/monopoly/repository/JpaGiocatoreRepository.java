package com.luca.monopoly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.luca.monopoly.domain.Segnalini;

@Repository
public interface JpaGiocatoreRepository extends JpaRepository<JpaGiocatore, Integer> {

    JpaGiocatore findBySegnalini(@Param("segnalini") Segnalini segnalini);

}
