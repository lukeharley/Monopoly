package com.luca.monopoly;

import java.util.Scanner;

public class Partita {
    public static void main(String[] args) {

        InizioPartita inizioPartita = new InizioPartita(); 
        Giocatore[] giocatori = inizioPartita.iniziaPartita();

        Giocatore giocatore1 = giocatori[0]; 
        Giocatore giocatore2 = giocatori[1]; 
        System.out.println(giocatore1.getNome() + " posiziona il segnalino a forma di " + giocatore1.getSegnalino().toString().toLowerCase() + " sul Via"); 
        System.out.println(giocatore2.getNome() + " posiziona il segnalino a forma di " + giocatore2.getSegnalino().toString().toLowerCase() + " sul Via"); 

        Scanner scanner = new Scanner(System.in); 
        
        System.out.println(giocatore1.getNome() + ", premi il tasto Invio per lanciare i dadi!"); 
        String input = scanner.nextLine(); 
        if(input.equals("Invio")) {
            giocatore1.setPosizione(giocatore1.lanciaDadi());
        System.out.println(giocatore1.getNome() + "sposta il segnalino a forma di " + giocatore1.getSegnalino() + "nella casella n° " + giocatore1.getPosizione());  
        } 

        scanner.close(); 

    }
}
