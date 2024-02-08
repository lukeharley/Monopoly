package com.luca.monopoly.domain;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class Partita {

    Monopoly monopoly = new Monopoly();
    Scanner scanner = new Scanner(System.in);
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

        while (giocatoreCorrente.getInBancarotta() == false && giocatoreCorrente.getPortafoglio() < 4000) {

            giocatoreCorrente = giocatori.get(indiceGiocatoreCorrente);
            System.out.println("Il giocatore attualmente in gioco è il giocatore n° " + indiceGiocatoreCorrente);

            int risultatoDado = giocatoreCorrente.lanciaDadi();
            System.out.println("Il giocatore "  + indiceGiocatoreCorrente + " tira il dado e ottiene il risultato " + risultatoDado); 
            
            giocatoreCorrente.aggiornaPosizioneEPortafoglio(risultatoDado, proprietariDeiContratti, caselle, contratti,
                    imprevisti, probabilita, giocatoreCorrente);
            System.out.println("Il giocatore " + indiceGiocatoreCorrente + " ora si trova in posizione " + giocatoreCorrente.getPosizione() + " e ha un portafoglio di " + giocatoreCorrente.getPortafoglio() + " euro"); 

            System.out.println("Premi INVIO per continuare...");
            scanner.nextLine();

            if (giocatoreCorrente.getPortafoglio() > 4000) {
                System.out.println("Il giocatore " + indiceGiocatoreCorrente + " ha vinto");
                break;
            }

            indiceGiocatoreCorrente = (indiceGiocatoreCorrente + 1) % numeroDiGiocatori;
            System.out.println("Ora tocca al giocatore " + indiceGiocatoreCorrente); 
 
        }
    }

    
}