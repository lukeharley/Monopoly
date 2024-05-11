package com.luca.monopoly.domain.giocatore;

public class GiocatoreRisultato {

    private int nuovaPosizione;
    private int nuovoPortafoglio;
    private boolean inBancarotta;

    public GiocatoreRisultato(int nuovaPosizione, int nuovoPortafoglio, boolean inBancarotta) {
        this.nuovaPosizione = nuovaPosizione;
        this.nuovoPortafoglio = nuovoPortafoglio;
        this.inBancarotta = inBancarotta;

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

    public boolean isInBancarotta() {
        return inBancarotta;
    }

    public void setInBancarotta(boolean inBancarotta) {
        this.inBancarotta = inBancarotta;
    }

}
