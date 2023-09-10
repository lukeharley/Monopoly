package com.luca.monopoly;

public class Giocatore {
    private final static int NUMERO_MAX_GIOCATORI = 2; 
    private String nome; 
    private Segnalini segnalino; 
    private int posizione; 
    private Dado dado; 

    public Giocatore(String nome, Segnalini segnalino) {
        this.nome = nome; 
        this.segnalino = segnalino; 
        this.posizione = 0; 
        this.dado = new Dado(); 
    }
    
    public static int getNumeroMaxGiocatori() {
        return NUMERO_MAX_GIOCATORI;
    }

    public String getNome() {
        return nome; 
    }

    public Segnalini getSegnalino() {
        return segnalino;
    }

    public int getPosizione() {
        return posizione; 
    }

    public int lanciaDadi() {
        return dado.getRisultatoLancioDadi();
    }

    public void setPosizione(int posizione) {
        this.posizione = posizione; 
    }


}
