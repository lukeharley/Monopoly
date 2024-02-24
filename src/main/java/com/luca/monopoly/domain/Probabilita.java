package com.luca.monopoly.domain;

import java.util.Collections;
import java.util.List;

public class Probabilita extends Carta {

    public Probabilita() {
        super();
    }

    public Probabilita(String testo, int importo, String nuovaPosizione, int shiftPosizione) {
        super(testo, importo, nuovaPosizione, shiftPosizione);
    }

    public void pescaCarta(List<Probabilita> mazzoCorrente, List<Probabilita> mazzoCartePescate) {
        if (!mazzoCorrente.isEmpty()) {
            Probabilita cartaPescata = mazzoCorrente.remove(0);
            mazzoCartePescate.add(cartaPescata);
            System.out.println("Testo della carta pescata: " + cartaPescata.getTesto());
        } else {
            Collections.shuffle(mazzoCartePescate);
            mazzoCorrente.addAll(mazzoCartePescate);
            mazzoCartePescate.clear();
            Probabilita cartaPescata = mazzoCorrente.remove(0);
            mazzoCartePescate.add(cartaPescata);
            System.out.println("Testo della carta pescata: " + cartaPescata.getTesto());
        }
    }

}
