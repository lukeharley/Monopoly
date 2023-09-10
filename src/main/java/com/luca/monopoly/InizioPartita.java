package com.luca.monopoly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InizioPartita {
    
    public Giocatore[] iniziaPartita() {

        Scanner scanner = new Scanner(System.in);  
        
        Giocatore[] giocatori = new Giocatore[Giocatore.getNumeroMaxGiocatori()];

        for(int i=0; i<Giocatore.getNumeroMaxGiocatori(); i++) {
            System.out.println("Inserisci il nome del giocatore " + (i + 1) + ": "); 
            String nome = scanner.nextLine(); 

            Segnalini[] segnaliniDisponibili = Segnalini.values();
            for (int j=0; j < segnaliniDisponibili.length; j++) {
                System.out.println((j+1) + ". " + segnaliniDisponibili[j].getNome()); 
            }
            System.out.println("Scegli un segnalino tra quelli disponibili, inserendo il numero corrispondente:");
            int sceltaSegnalino = scanner.nextInt();
            scanner.nextLine();

            Segnalini segnalinoScelto = segnaliniDisponibili[sceltaSegnalino - 1];
            giocatori[i] = new Giocatore(nome, segnalinoScelto);

            List<Segnalini> segnaliniRimanenti = new ArrayList<>(Arrays.asList(segnaliniDisponibili));
            segnaliniRimanenti.remove(segnalinoScelto);
            segnaliniDisponibili = segnaliniRimanenti.toArray(new Segnalini[0]);
        }

        scanner.close(); 
        return giocatori; 

        }
    }
