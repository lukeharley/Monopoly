package com.luca.monopoly;

import java.util.Collections;
import java.util.List;

public class Giocatore {
    private final static int NUMERO_MAX_GIOCATORI = 2;
    private String nome;
    private Segnalini segnalino;
    private int posizione;
    private Dado dado;
    private int turno;

    public Giocatore(String nome, Segnalini segnalino) {
        this.nome = nome;
        this.segnalino = segnalino;
        this.posizione = 0;
        this.dado = new Dado();
        this.turno = 0;
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

    public int getTurno() {
        return turno;
    }

    public <T> void pescaCarta(List<T> mazzoCorrente, List<T> mazzoCartePescate) {
        if (!mazzoCorrente.isEmpty()) {
            T cartaPescata = mazzoCorrente.remove(0);
            mazzoCartePescate.add(cartaPescata);
            System.out.println("Testo della carta pescata: " + cartaPescata);
        } else {
            Collections.shuffle(mazzoCartePescate);
            mazzoCorrente.addAll(mazzoCartePescate);
            mazzoCartePescate.clear();
        }

    }
}