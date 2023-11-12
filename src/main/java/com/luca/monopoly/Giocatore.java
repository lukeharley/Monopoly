package com.luca.monopoly;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Giocatore {
    private Segnalini segnalino;
    private int portafoglio;
    private int posizione;

    public Giocatore(Segnalini segnalino, int portafoglio, int posizione) {
        this.segnalino = segnalino;
        this.portafoglio = portafoglio;
        this.posizione = posizione;
    }

    public Segnalini getSegnalino() {
        return segnalino;
    }

    public void setSegnalino(Segnalini segnalino) {
        this.segnalino = segnalino;
    }

    public int getPortafoglio() {
        return portafoglio;
    }

    public void setPortafoglio(int portafoglio) {
        this.portafoglio = portafoglio;
    }

    public void aggiornaPosizioneEPortafoglio(int risultatoDado, Map<String, Giocatore> proprietariDeiContratti,
            String nomeProprieta, Contratto contratto, Map<String, Integer> numeroDiCasetteSullaCasella) {

        this.posizione += risultatoDado;

        aggiornaPortafoglioSePassaDalVia();

        aggiornaPortafoglioSePassaDaTerrenoOCasaInAffitto(proprietariDeiContratti,
                nomeProprieta, contratto, numeroDiCasetteSullaCasella);

        this.posizione = this.posizione % 40;

    }

    private void aggiornaPortafoglioSePassaDalVia() {
        if (this.posizione > 40) {
            this.portafoglio += 500;
        }
    }

    private void aggiornaPortafoglioSePassaDaTerrenoOCasaInAffitto(Map<String, Giocatore> proprietariDeiContratti,
            String nomeProprieta, Contratto contratto, Map<String, Integer> numeroDiCasetteSullaCasella) {

        if (proprietariDeiContratti.get(nomeProprieta) != null) {
            int numeroCasette = numeroDiCasetteSullaCasella.get(nomeProprieta);
            int affitto = contratto.calcolaAffitto(numeroCasette);
            this.portafoglio -= affitto;
        }
    }

    public int lanciaDadi() {
        return generaNumeroCasuale(2, 12);
    }

    private int generaNumeroCasuale(int valoreMinimo, int valoreMassimo) {

        if (valoreMinimo >= valoreMassimo) {
            throw new IllegalArgumentException("il valore massimo deve essere maggiore del valore minimo");
        }

        final Random r = new Random();
        return r.nextInt(valoreMassimo - valoreMinimo + 1) + valoreMinimo;
    }

    public int getPosizione() {
        return posizione;
    }

    public void compraProprieta(Map<String, Giocatore> proprietariDeiContratti, String nomeProprieta,
            List<Casella> caselle) {
        if (proprietariDeiContratti.containsKey(nomeProprieta)) {
            proprietariDeiContratti.put(nomeProprieta, this);
            portafoglio -= caselle.stream().filter(casella -> casella.getTesto().equals(nomeProprieta)).findFirst()
                    .get().getCostoProprieta();
        }
    }

    @Override
    public String toString() {
        return "Segnalino: " + segnalino + " Portafoglio: " + portafoglio + " Posizione: " + posizione;
    }
}