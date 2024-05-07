package com.luca.monopoly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luca.monopoly.domain.Giocatore;

@Repository
public interface JpaGiocatoreRepository extends JpaRepository<Giocatore, Integer> {

}
