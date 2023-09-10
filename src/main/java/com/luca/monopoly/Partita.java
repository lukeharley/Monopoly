/* package com.luca.monopoly;

import java.util.Scanner;

public class Partita {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  

        for(int i = 0; i <= Giocatore.getNumeroMaxGiocatori(); i++) {
            System.out.println("Inserisci il nome del giocatore " + (i + 1) + ": ");
            String nome = scanner.nextLine(); 
            System.out.println("Scegli un segnalino tra quelli disponibili:");
            Segnalini[] segnaliniDisponibili = Segnalini.values();
            for (int j = 0; j < segnaliniDisponibili.length; j++) {
                System.out.println((j + 1) + ". " + segnaliniDisponibili[j].getNome());
            }
            int sceltaSegnalino = scanner.nextInt();
            Segnalini segnalinoScelto = segnaliniDisponibili[sceltaSegnalino - 1];

            scanner.nextLine(); // Consuma la riga vuota dopo l'input numerico
            Giocatore giocatore1 = new Giocatore(nome, segnalinoScelto); 
        }

        giocatore1.lanciaDadi(); 

    }
} */
