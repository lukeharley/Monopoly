package com.luca.monopoly;

import java.util.Random;

public class Dado {
    private final int NUMERO_DADI = 2;
    private final int NUMERO_FACCE = 6;
    private Random random = new Random();

    public int getNumeroDadi() {
        return NUMERO_DADI;
    }

    public int getNumeroFacce() {
        return NUMERO_FACCE;
    }

    public int getRisultatoLancioDadi() {
        return random.nextInt(((NUMERO_DADI * NUMERO_FACCE) - 1) + 2);
    }

}
