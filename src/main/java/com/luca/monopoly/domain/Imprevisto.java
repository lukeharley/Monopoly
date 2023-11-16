package com.luca.monopoly.domain;

import java.util.Collections;
import java.util.List;

public class Imprevisto extends Carta {

    public Imprevisto() {
        super();
    }

    public Imprevisto(String testo, int importo, int shiftPosizione) {
        super(testo, importo, shiftPosizione);
    }

    public void pescaCarta(List<Imprevisto> mazzoCorrente, List<Imprevisto> mazzoCartePescate) {
        if (!mazzoCorrente.isEmpty()) {
            Imprevisto cartaPescata = mazzoCorrente.remove(0);
            mazzoCartePescate.add(cartaPescata);
            System.out.println("Testo della carta pescata: " + cartaPescata.getTesto());
        } else {
            Collections.shuffle(mazzoCartePescate);
            mazzoCorrente.addAll(mazzoCartePescate);
            mazzoCartePescate.clear();
        }
    }

}
