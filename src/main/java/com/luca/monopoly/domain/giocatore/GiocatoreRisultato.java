package com.luca.monopoly.domain.giocatore;

public class GiocatoreRisultato {

    private int nuovaPosizione;
    private int nuovoPortafoglio;

    public GiocatoreRisultato(int nuovaPosizione, int nuovoPortafoglio) {
        this.nuovaPosizione = nuovaPosizione;
        this.nuovoPortafoglio = nuovoPortafoglio;
    }

    public int getNuovaPosizione() {
        return nuovaPosizione;
    }

    public void setNuovaPosizione(int nuovaPosizione) {
        this.nuovaPosizione = nuovaPosizione;
    }

    public int getNuovoPortafoglio() {
        return nuovoPortafoglio;
    }

    public void setNuovoPortafoglio(int nuovoPortafoglio) {
        this.nuovoPortafoglio = nuovoPortafoglio;
    }

}
