package com.luca.monopoly.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.luca.monopoly.domain.Segnalini;
import com.luca.monopoly.domain.Imprevisto;
import com.luca.monopoly.domain.Probabilita;
import com.luca.monopoly.domain.Contratto;
import com.luca.monopoly.domain.Casella;
import com.luca.monopoly.domain.giocatore.Giocatore;
import com.luca.monopoly.domain.giocatore.GiocatoreRisultato;

@Service
public class GiocatoreService {

    private Giocatore giocatore;

    private GiocatoreService() {
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

        return giocatoreRisultato;
    }

}