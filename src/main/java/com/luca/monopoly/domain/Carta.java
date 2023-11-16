package com.luca.monopoly.domain;

public class Carta {

    private String testo;
    private int importo;
    private int shiftPosizione;

    public Carta() {

    }

    public Carta(String testo, int importo, int shiftPosizione) {
        this.testo = testo;
        this.importo = importo;
        this.shiftPosizione = shiftPosizione;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public int getImporto() {
        return importo;
    }

    public void setImporto(int importo) {
        this.importo = importo;
    }

    public int getShiftPosizione() {
        return shiftPosizione;
    }

    public void setShiftPosizione(int shiftPosizione) {
        this.shiftPosizione = shiftPosizione;
    }

}
