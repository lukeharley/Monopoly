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

    public void aggiornaPosizioneEPortafoglio(int risultatoDado) {

        this.posizione += risultatoDado;

        aggiornaPortafoglioSePassaDalVia();

        this.posizione = this.posizione % 40;
    }

    private void aggiornaPortafoglioSePassaDalVia() {
        if (this.posizione > 40) {
            this.portafoglio += 200;
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
        Optional<Contratto> contrattoOptional =
            contrattiDellaBanca.stream().filter(contratto -> contratto.getTesto().equals(nomeProprieta)).findFirst();

        if (contrattoOptional.isPresent()) {
            contratti.add(contrattoOptional.get());
            contrattiDellaBanca.remove(contrattoOptional.get());
            portafoglio -= caselle.stream().filter(casella -> casella.getTesto().equals(nomeProprieta)).findFirst().get().getCostoProprieta();
        }
    }

    public List<Contratto> getContratti() {
        return contratti;
    }
}
