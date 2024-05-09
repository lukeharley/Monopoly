package com.luca.monopoly.service;

import com.luca.monopoly.domain.Partita;
import com.luca.monopoly.repository.JpaGiocatoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartitaService {


    @Autowired
    private JpaGiocatoreRepository jpaGiocatoreRepository;


    public void nuovaPartita() {
        Partita partita = new Partita();
        partita.giocaPartita();
    }

}
