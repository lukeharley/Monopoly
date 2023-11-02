package com.luca.monopoly;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Giocatore {
    private Segnalini segnalino;

    private int portafoglio;
    private int posizione;
    private final List<Contratto> contratti = new ArrayList<>();
    private final List<Contratto> contrattiAltriGiocatori = new ArrayList<>();

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

    public void aggiornaPosizioneEPortafoglio(List<Giocatore> altriGiocatori, int risultatoDado,
            List<Contratto> contratti, List<Casella> caselle) {

        this.posizione += risultatoDado;

        aggiornaPortafoglioSePassaDalVia();
        aggiornaPortafoglioSePassaDaTerrenoInAffitto(altriGiocatori, caselle);
        this.posizione = this.posizione % 40;

    }

    private void aggiornaPortafoglioSePassaDalVia() {
        if (this.posizione > 40) {
            this.portafoglio += 500;
        }
    }

    private void aggiornaPortafoglioSePassaDaTerrenoInAffitto(List<Giocatore> altriGiocatori, List<Casella> caselle) {

        List<Contratto> contrattiAltriGiocatori = new ArrayList<>();

        for (Giocatore giocatoreCorrente : altriGiocatori) {
            contrattiAltriGiocatori.addAll(giocatoreCorrente.getContratti(altriGiocatori));
        }

        Optional<Contratto> contrattoPossedutoOptional = contrattiAltriGiocatori.stream()
                .filter(contratto -> contratto.getTesto().equals(caselle.get(this.posizione).getTesto()))
                .findFirst();

        if (contrattoPossedutoOptional.isPresent()) {
            this.portafoglio -= contrattoPossedutoOptional.get().getRenditaTerreno();
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

    public void compraProprieta(List<Contratto> contrattiDellaBanca, List<Casella> caselle, String nomeProprieta) {
        Optional<Contratto> contrattoOptional = contrattiDellaBanca.stream()
                .filter(contratto -> contratto.getTesto().equals(nomeProprieta)).findFirst();

        if (contrattoOptional.isPresent()) {
            contratti.add(contrattoOptional.get());
            contrattiDellaBanca.remove(contrattoOptional.get());
            portafoglio -= caselle.stream().filter(casella -> casella.getTesto().equals(nomeProprieta)).findFirst()
                    .get().getCostoProprieta();
        }
    }

    public List<Contratto> getContratti() {
        return contratti;
    }

    public List<Contratto> getContratti(List<Giocatore> altriGiocatori) {
        List<Contratto> contrattiAltriGiocatori = new ArrayList<>();

        for (Giocatore giocatore : altriGiocatori) {
            contrattiAltriGiocatori.addAll(giocatore.getContratti());
        }

        return contrattiAltriGiocatori;
    }
}