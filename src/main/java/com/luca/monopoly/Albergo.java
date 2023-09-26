package com.luca.monopoly;

import java.util.List;
import java.util.ArrayList;

public class Albergo extends Casa {

    private final int NUMERO_MAX_PEZZI_ALBERGO = 12;

    public Albergo() {
    }

    public List<Integer> getNumeroPezzi() {

        List<Integer> numeroPezzi = new ArrayList<>();

        for (int i = 1; i <= NUMERO_MAX_PEZZI_ALBERGO; i++) {
            numeroPezzi.add(i);
        }

        return numeroPezzi;

    }

}
