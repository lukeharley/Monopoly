package com.luca.monopoly.domain;

import java.util.List;
import java.util.Map;

public class Partita {

    private int indiceGiocatoreCorrente = 0;

    Monopoly monopoly = new Monopoly();
    List<Giocatore> giocatori = monopoly.getGiocatori();
    Tabellone tabellone = monopoly.getTabellone();
    List<Casella> caselle = tabellone.getCaselle();
    List<Contratto> contratti = tabellone.getContratti();
    List<Imprevisto> imprevisti = tabellone.getImprevisti();
    List<Probabilita> probabilita = tabellone.getProbabilita();
    Map<String, Giocatore> proprietariDeiContratti = monopoly.getTabellone().getProprietariDeiContratti();

    private void giocaPartita() {
        while (indiceGiocatoreCorrente < 2) {
            int numeroDiGiocatori = giocatori.size();

            Giocatore giocatoreCorrente = giocatori.get(indiceGiocatoreCorrente);

            int risultatoDado = giocatoreCorrente.lanciaDadi();
            giocatoreCorrente.aggiornaPosizioneEPortafoglio(risultatoDado, proprietariDeiContratti, caselle, contratti,
                    imprevisti, probabilita);
            indiceGiocatoreCorrente = (indiceGiocatoreCorrente + 1) % numeroDiGiocatori;

        }
    }

    // partita.giocaPartita();
}
