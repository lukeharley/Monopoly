package com.luca.monopoly;

public class Partita {
    public static void main(String[] args) {

        Giocatore giocatore1 = new Giocatore("Mario", Segnalini.CANE);
        Giocatore giocatore2 = new Giocatore("Luigi", Segnalini.DINOSAURO);

        Tabellone tabellone = new Tabellone();

//        int nuovaPosizione1 = giocatore1.getPosizione() + giocatore1.lanciaDadi();
//        System.out.println(tabellone.getCaselle().get(nuovaPosizione1).getTesto());
//
//        int nuovaPosizione2 = giocatore2.getPosizione() + giocatore2.lanciaDadi();
//        System.out.println(tabellone.getCaselle().get(nuovaPosizione2).getTesto());

    }
}
