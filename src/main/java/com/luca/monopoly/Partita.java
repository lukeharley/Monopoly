package com.luca.monopoly;


public class Partita {
    public static void main(String[] args) {

        Giocatore giocatore1 = new Giocatore("Mario", Segnalini.CANE); 
        Giocatore giocatore2 = new Giocatore("Luigi", Segnalini.DINOSAURO); 

        int nuovaPosizione1 = giocatore1.getPosizione() + giocatore1.lanciaDadi(); 
        int nuovaPosizione2 = giocatore2.getPosizione() + giocatore2.lanciaDadi();




    }
}
