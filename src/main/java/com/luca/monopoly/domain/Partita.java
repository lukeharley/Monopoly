/*
 * package com.luca.monopoly.domain;
 * 
 * import java.util.List;
 * import java.util.Map;
 * import java.util.Scanner;
 * 
 * public class Partita {
 * 
 * Monopoly monopoly = new Monopoly();
 * Scanner scanner = new Scanner(System.in);
 * List<Giocatore> giocatori = monopoly.getGiocatori();
 * Tabellone tabellone = monopoly.getTabellone();
 * List<Casella> caselle = tabellone.getCaselle();
 * List<Contratto> contratti = tabellone.getContratti();
 * List<Imprevisto> imprevisti = tabellone.getImprevisti();
 * List<Probabilita> probabilita = tabellone.getProbabilita();
 * Map<String, Giocatore> proprietariDeiContratti =
 * monopoly.getTabellone().getProprietariDeiContratti();
 * 
 * public void giocaPartita() {
 * 
 * StringBuilder sb = new StringBuilder();
 * 
 * int indiceGiocatoreCorrente = 0;
 * int numeroDiGiocatori = giocatori.size();
 * Giocatore giocatoreCorrente = giocatori.get(indiceGiocatoreCorrente);
 * 
 * // partita in loop, che io gestirò con una comunicazione asincrona tra
 * frontend
 * // e backend
 * // while (giocatoreCorrente.getInBancarotta() == false) {
 * 
 * giocatoreCorrente = giocatori.get(indiceGiocatoreCorrente);
 * sb.append("Il giocatore attualmente in gioco è il giocatore n° " +
 * indiceGiocatoreCorrente
 * + ". Si trova in posizione " + giocatoreCorrente.getPosizione() +
 * " e ha un portafoglio di "
 * + giocatoreCorrente.getPortafoglio() + " euro");
 * 
 * // lancio del dado e aggiornamento della posizione e del portafoglio
 * int risultatoDado = giocatoreCorrente.lanciaDadi();
 * sb.append("Il giocatore " + indiceGiocatoreCorrente +
 * " tira il dado e ottiene il risultato "
 * + risultatoDado);
 * giocatoreCorrente.aggiornaPosizioneEPortafoglio(risultatoDado,
 * proprietariDeiContratti, caselle, contratti,
 * imprevisti, probabilita, giocatoreCorrente);
 * 
 * // risultato = response
 * sb.append("Il giocatore " + indiceGiocatoreCorrente +
 * " ora si trova in posizione "
 * + giocatoreCorrente.getPosizione() + " e ha un portafoglio di " +
 * giocatoreCorrente.getPortafoglio()
 * + " euro");
 * 
 * // condizione di vittoria - conclusione del gioco
 * /*
 * if (bancarotta(giocatoreCorrente)) {
 * break;
 * }
 */

// questa parte sarà sostituita con elementi dell'interfaccia che consentiranno
// l'interazione da parte dell'utente (es. pulsante per lanciare il dado) //
// sarà reso di nuovo cliccabile ed effettivo il pulsante lancio dadi ma per
// l'altro giocatore
/*
 * sb.append("Premi INVIO per continuare...");
 * scanner.nextLine();
 * 
 * // il passaggio da un giocatore all'altro forse deve avvenire lato client (da
 * // verificare)
 * indiceGiocatoreCorrente = (indiceGiocatoreCorrente + 1) % numeroDiGiocatori;
 * sb.append("Ora tocca al giocatore " + indiceGiocatoreCorrente);
 * 
 * // return sb.toString();
 * 
 * // }
 * 
 * // return sb.toString();
 * }
 * 
 * private Boolean bancarotta(Giocatore giocatoreCorrente) {
 * if (giocatoreCorrente.getPortafoglio() < 0) {
 * giocatoreCorrente.setInBancarotta(true);
 * System.out.
 * println("Il giocatore corrente è in bancarotta. L'altro giocatore ha vinto");
 * }
 * return giocatoreCorrente.getInBancarotta();
 * }
 * 
 * public int lanciaDadi() {
 * 
 * }
 * 
 * }
 */