package com.luca.monopoly.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class Giocatore {
    private Segnalini segnalino;
    private int portafoglio;
    private int posizione;
    private List<Imprevisto> mazzoCartePescateImprevisti = new ArrayList<>();
    private List<Probabilita> mazzoCartePescateProbabilita = new ArrayList<>();

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
            List<Casella> caselle, List<Contratto> contratti, List<Imprevisto> imprevisti,
            List<Probabilita> probabilita) {

        this.posizione += risultatoDado;
        aggiornaPosizioneEPortafoglioSePassaDalVia();

        aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);
        aggiornaPosizioneEPortafoglioSeProbabilita(caselle, probabilita, mazzoCartePescateProbabilita);
        aggiornaPortafoglioSeTasse(caselle, contratti);

        String nomeProprieta = caselle.get(this.posizione).getTesto();
        int numeroCasette = caselle.get(this.posizione).getNumeroDiCasetteSullaCasella();

        Optional<Contratto> contrattoOptional = contratti.stream()
                .filter(contratto -> contratto.getTesto().equals(nomeProprieta)).findFirst();

        if (proprietariDeiContratti.get(nomeProprieta) != null) {
            int affitto = contrattoOptional.get().calcolaAffitto(numeroCasette);
            this.portafoglio -= affitto;
        }
    }

    private void aggiornaPortafoglioSeTasse(List<Casella> caselle, List<Contratto> contratti) {
        if (caselle.get(this.posizione).getTesto().startsWith("Società")
                || caselle.get(this.posizione).getTesto().startsWith("Stazione")) {
            this.portafoglio -= contratti.get(this.posizione).getTassa();
        } else if (caselle.get(this.posizione).getTesto().startsWith("Tassa Patrimoniale")) {
            this.portafoglio -= 40;
        } else if (caselle.get(this.posizione).getTesto().startsWith("Tassa di Lusso")) {
            this.portafoglio -= 250;
        }
    }

    private void aggiornaPosizioneEPortafoglioSeProbabilita(List<Casella> caselle, List<Probabilita> probabilita,
            List<Probabilita> mazzoCartePescateProbabilita) {

        if (caselle.get(this.posizione).getTesto().equals("Probabilità")) {
            Probabilita probabilitaCorrente = probabilita.get(0);
            this.posizione += probabilitaCorrente.getShiftPosizione();
            this.portafoglio += probabilitaCorrente.getImporto();
            probabilitaCorrente.pescaCarta(probabilita, mazzoCartePescateProbabilita);
        }
    }

    private void aggiornaPosizioneEPortafoglioSeImprevisto(List<Casella> caselle, List<Imprevisto> imprevisti,
            List<Imprevisto> mazzoCartePescateImprevisti) {

        if (caselle.get(this.posizione).getTesto().equals("Imprevisti")) {
            Imprevisto imprevistoCorrente = imprevisti.get(0);
            this.posizione += imprevistoCorrente.getShiftPosizione();
            this.portafoglio += imprevistoCorrente.getImporto();
            imprevistoCorrente.pescaCarta(imprevisti, mazzoCartePescateImprevisti);
        }
    }

    private int aggiornaPosizioneEPortafoglioSePassaDalVia() {
        if (this.posizione > 40) {
            this.portafoglio += 500;
            this.posizione %= 40;
        }
        return this.posizione;
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