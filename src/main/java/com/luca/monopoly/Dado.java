package com.luca.monopoly;

import java.util.Random;

public class Dado {
    private final int NUMERO_FACCE = 6;

    public int getNumeroFacce() {
        return NUMERO_FACCE;
    }

    public int getRisultatoLancioDadi() {
        return 0;
    }

    public int lancia() {

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
