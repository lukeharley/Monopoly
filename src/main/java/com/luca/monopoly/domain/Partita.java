package com.luca.monopoly.domain;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luca.monopoly.AppConfig;
import com.luca.monopoly.repository.JpaGiocatoreRepository;

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

    @Autowired
    private JpaGiocatoreRepository jpaGiocatoreRepository;

    public Partita(JpaGiocatoreRepository jpaGiocatoreRepository) {
        this.jpaGiocatoreRepository = jpaGiocatoreRepository;
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        JpaGiocatoreRepository jpaGiocatoreRepository = context.getBean(JpaGiocatoreRepository.class);

        Partita partita = new Partita(jpaGiocatoreRepository);

        partita.giocaPartita();

        context.close();
    }

    private void giocaPartita() {

        int indiceGiocatoreCorrente = 0;
        int numeroDiGiocatori = giocatori.size();
        Giocatore giocatoreCorrente = giocatori.get(indiceGiocatoreCorrente);

        while (giocatoreCorrente.getInBancarotta() == false) {

            giocatoreCorrente = giocatori.get(indiceGiocatoreCorrente);
            System.out.println("Il giocatore attualmente in gioco è il giocatore n° " + indiceGiocatoreCorrente
                    + ". Si trova in posizione " + giocatoreCorrente.getPosizione() + " e ha un portafoglio di "
                    + giocatoreCorrente.getPortafoglio() + " euro");

            int risultatoDado = giocatoreCorrente.lanciaDadi();
            System.out.println("Il giocatore " + indiceGiocatoreCorrente + " tira il dado e ottiene il risultato "
                    + risultatoDado);

            giocatoreCorrente.aggiornaPosizioneEPortafoglio(risultatoDado, proprietariDeiContratti, caselle, contratti,
                    imprevisti, probabilita, giocatoreCorrente);

            System.out.println("Il giocatore " + indiceGiocatoreCorrente + " ora si trova in posizione "
                    + giocatoreCorrente.getPosizione() + " e ha un portafoglio di " + giocatoreCorrente.getPortafoglio()
                    + " euro");
            jpaGiocatoreRepository.updatePosizione(giocatoreCorrente.getId(), giocatoreCorrente.getPosizione());

            if (bancarotta(giocatoreCorrente)) {
                break;
            }

            System.out.println("Premi INVIO per continuare...");
            scanner.nextLine();

            indiceGiocatoreCorrente = (indiceGiocatoreCorrente + 1) % numeroDiGiocatori;
            System.out.println("Ora tocca al giocatore " + indiceGiocatoreCorrente);

        }
    }

    private Boolean bancarotta(Giocatore giocatoreCorrente) {
        if (giocatoreCorrente.getPortafoglio() < 0) {
            giocatoreCorrente.setInBancarotta(true);
            System.out.println("Il giocatore corrente è in bancarotta. L'altro giocatore ha vinto");
        }
        return giocatoreCorrente.getInBancarotta();
    }

}