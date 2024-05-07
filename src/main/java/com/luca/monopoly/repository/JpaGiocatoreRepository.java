package com.luca.monopoly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.luca.monopoly.domain.Giocatore;

@Repository
public interface JpaGiocatoreRepository extends JpaRepository<Giocatore, Integer> {

    @Modifying
    @Query("UPDATE Giocatore g SET g.posizione = :posizione WHERE g.id = :id")
    void updatePosizione(@Param("id") int id, @Param("posizione") int posizione);

}
