package com.luca.monopoly.domain;

public class Carta {

    private String testo;
    private int importo;
    private String nuovaPosizione;
    private int shiftPosizione;

    public Carta() {

    }

    public Carta(String testo, int importo, String nuovaPosizione, int shiftPosizione) {
        this.testo = testo;
        this.importo = importo;
        this.nuovaPosizione = nuovaPosizione;
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

    public String getNuovaPosizione() {
        return nuovaPosizione;
    }

    public void setNuovaPosizione(String nuovaPosizione) {
        this.nuovaPosizione = nuovaPosizione;
    }

    public int getShiftPosizione() {
        return shiftPosizione;
    }

    public void setShiftPosizione(int shiftPosizione) {
        this.shiftPosizione = shiftPosizione;
    }

    public static boolean eUnNumero(String str) {
        boolean isNumeric = str.matches("[+-]?\\d*(\\.\\d+)?");
        return isNumeric;
    }

}
