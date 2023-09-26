package com.luca.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Casa {

    private final int NUMERO_MAX_PEZZI_CASA = 32;

    public Casa() {
    }

    public List<Integer> getNumeroPezzi() {

        List<Integer> numeroPezzi = new ArrayList<>();

        for (int i = 1; i <= NUMERO_MAX_PEZZI_CASA; i++) {
            numeroPezzi.add(i);
        }

        return numeroPezzi;

    }
}
