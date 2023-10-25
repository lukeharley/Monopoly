package com.luca.monopoly;

import java.util.Random;

public class Giocatore {
    private Segnalini segnalino;
    private int portafoglio;

    public Giocatore(Segnalini segnalino) {
        this.segnalino = segnalino;
    }

    public Segnalini getSegnalino() {
        return segnalino;
    }

    public int setNuovaPosizione(int posizione, int risultatoDado) {

        int nuovaPosizione = (posizione + risultatoDado) % 40;

        if ((posizione + risultatoDado) > 40) {
            portafoglio = portafoglio + 200;
        }

        return nuovaPosizione;
    }

    public int lanciaDadi() {
        return generaNumeroCasuale(1, 6);
    }

    private int generaNumeroCasuale(int valoreMinimo, int valoreMassimo) {

        if (valoreMinimo >= valoreMassimo) {
            throw new IllegalArgumentException("il valore massimo deve essere maggiore del valore minimo");
        }

        final Random r = new Random();
        return r.nextInt(valoreMassimo - valoreMinimo + 1) + valoreMinimo;
    }

}
