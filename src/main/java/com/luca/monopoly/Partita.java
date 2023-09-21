package com.luca.monopoly;


public class Partita {
    public static void main(String[] args) {

        Giocatore giocatore1 = new Giocatore("Mario", Segnalini.CANE); 
        Giocatore giocatore2 = new Giocatore("Luigi", Segnalini.DINOSAURO); 

        giocatore1.lanciaDadi(); 
        giocatore2.lanciaDadi();



    }
}
