package com.luca.monopoly.service;

import com.luca.monopoly.domain.*;
import com.luca.monopoly.domain.giocatore.Giocatore;
import com.luca.monopoly.domain.giocatore.GiocatoreRisultato;
import com.luca.monopoly.repository.JpaGiocatoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GiocatoreService {

    private Giocatore giocatore;

    @Autowired
    private JpaGiocatoreRepository jpaGiocatoreRepository;

    public GiocatoreService() {
        giocatore = new Giocatore("", Segnalini.CANE, 1500, 0);
    }

    public int ottieniRisultatoDado() {
        int risultatoDado = giocatore.lanciaDadi();
        return risultatoDado;
    }

    public GiocatoreRisultato ottieniNuovaPosizioneENuovoPortafoglio(int risultatoDado,
            Map<String, Giocatore> proprietariDeiContratti,
            List<Casella> caselle, List<Contratto> contratti, List<Imprevisto> imprevisti,
            List<Probabilita> probabilita, Giocatore giocatoreCorrente) {

        GiocatoreRisultato giocatoreRisultato = giocatore.aggiornaPosizioneEPortafoglio(risultatoDado,
                proprietariDeiContratti, caselle, contratti, imprevisti, probabilita, giocatoreCorrente);

        if (giocatoreRisultato.isInBancarotta()) {
            /// interrompi partita e resetta tutto
        }

        return giocatoreRisultato;
    }

    public void eliminaGiocatori() {

        jpaGiocatoreRepository.deleteAll();
    }

}