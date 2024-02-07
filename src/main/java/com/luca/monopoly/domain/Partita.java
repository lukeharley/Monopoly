package com.luca.monopoly.domain;

import java.util.List;
import java.util.Map;

public class Partita {

    Monopoly monopoly = new Monopoly();
    List<Giocatore> giocatori = monopoly.getGiocatori();
    Tabellone tabellone = monopoly.getTabellone();
    List<Casella> caselle = tabellone.getCaselle();
    List<Contratto> contratti = tabellone.getContratti();
    List<Imprevisto> imprevisti = tabellone.getImprevisti();
    List<Probabilita> probabilita = tabellone.getProbabilita();
    Map<String, Giocatore> proprietariDeiContratti = monopoly.getTabellone().getProprietariDeiContratti();

    public static void main(String[] args) {

        Partita partita = new Partita(); 

        partita.giocaPartita();
    }

    
    private void giocaPartita() {

        int indiceGiocatoreCorrente = 0;
        int numeroDiGiocatori = giocatori.size();
        Giocatore giocatoreCorrente = giocatori.get(indiceGiocatoreCorrente);

        while (giocatoreCorrente.getInBancarotta() == false) {

            giocatoreCorrente = giocatori.get(indiceGiocatoreCorrente);

            int risultatoDado = giocatoreCorrente.lanciaDadi();
            giocatoreCorrente.aggiornaPosizioneEPortafoglio(risultatoDado, proprietariDeiContratti, caselle, contratti,
                    imprevisti, probabilita, giocatoreCorrente);
            indiceGiocatoreCorrente = (indiceGiocatoreCorrente + 1) % numeroDiGiocatori;

        }
    }

    
}