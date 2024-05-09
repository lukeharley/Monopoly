package com.luca.monopoly.service;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luca.monopoly.domain.Giocatore;
import com.luca.monopoly.domain.Segnalini;
// import com.luca.monopoly.repository.JpaGiocatoreRepository;

@Service
public class GiocatoreService {

    // @Autowired
    // private JpaGiocatoreRepository jpaGiocatoreRepository;

    private static final GiocatoreService ISTANZA = new GiocatoreService();

    private Giocatore giocatore;

    private GiocatoreService() {
        giocatore = new Giocatore("", Segnalini.CANE, 1500, 0);
    }

    public static GiocatoreService getIstanza() {
        return ISTANZA;
    }

    public int ottieniRisultatoDado() {
        int risultatoDado = giocatore.lanciaDadi();
        return risultatoDado;
    }

    public int ottieniNuovaPosizione(int risultatoDado) {
        int nuovaPosizione = giocatore.aggiornaPosizione(risultatoDado);
        return nuovaPosizione;
    }

    public int ottieniNuovoPortafoglio() {
        int nuovoPortafoglio = giocatore.aggiornaPortafoglio();
        return nuovoPortafoglio;
    }

}