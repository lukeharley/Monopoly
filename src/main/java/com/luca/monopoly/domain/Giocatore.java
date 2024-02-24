package com.luca.monopoly.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class Giocatore {
    private Segnalini segnalino;
    private int portafoglio;
    private int posizione;
    private Boolean inBancarotta;
    private List<Imprevisto> mazzoCartePescateImprevisti = new ArrayList<>();
    private List<Probabilita> mazzoCartePescateProbabilita = new ArrayList<>();

    public Giocatore(Segnalini segnalino, int portafoglio, int posizione) {
        this.segnalino = segnalino;
        this.portafoglio = portafoglio;
        this.posizione = posizione;
        this.inBancarotta = false;
    }

    public int getPosizione() {
        return posizione;
    }

    public void setPosizione(int posizione) {
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

    public List<Imprevisto> getMazzoCartePescateImprevisti() {
        return mazzoCartePescateImprevisti;
    }

    public void setMazzoCartePescateImprevisti(List<Imprevisto> mazzoCartePescateImprevisti) {
        this.mazzoCartePescateImprevisti = mazzoCartePescateImprevisti;
    }

    public List<Probabilita> getMazzoCartePescateProbabilita() {
        return mazzoCartePescateProbabilita;
    }

    public void setMazzoCartePescateProbabilita(List<Probabilita> mazzoCartePescateProbabilita) {
        this.mazzoCartePescateProbabilita = mazzoCartePescateProbabilita;
    }

    public Boolean getInBancarotta() {
        return inBancarotta;
    }

    public void setInBancarotta(Boolean inBancarotta) {
        this.inBancarotta = inBancarotta;
    }

    public void bancarotta(Giocatore giocatoreCorrente) {
        if (giocatoreCorrente.portafoglio < 0) {
            giocatoreCorrente.inBancarotta = true;
            System.out.println("Il giocatore corrente è in bancarotta. L'altro giocatore ha vinto");
        }
    }

    public void aggiornaPosizioneEPortafoglio(int risultatoDado, Map<String, Giocatore> proprietariDeiContratti,
            List<Casella> caselle, List<Contratto> contratti, List<Imprevisto> imprevisti,
            List<Probabilita> probabilita, Giocatore giocatoreCorrente) {

        aggiornaPosizione(risultatoDado);
        aggiornaPosizioneSePassaDalVia();
        System.out.println("Il giocatore arriva nella casella " + caselle.get(this.posizione).getTesto());
        aggiornaPosizioneSeInPrigione();
        aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);
        aggiornaPosizioneEPortafoglioSeProbabilita(caselle, probabilita, mazzoCartePescateProbabilita);
        aggiornaPortafoglioSeTasse(proprietariDeiContratti, giocatoreCorrente, caselle, contratti);

        String nomeProprieta = caselle.get(this.posizione).getTesto();

        if (proprietariDeiContratti.get(nomeProprieta) != giocatoreCorrente
                && proprietariDeiContratti.get(nomeProprieta) != null) {
            aggiornaPortafoglioSeAffitto(caselle, contratti, proprietariDeiContratti, giocatoreCorrente);
        } else if (proprietariDeiContratti.get(nomeProprieta) == null) {
            compraProprieta(proprietariDeiContratti, caselle);
        } else if ((proprietariDeiContratti.get(nomeProprieta) == giocatoreCorrente)) {
            costruisciCasette(proprietariDeiContratti, caselle);
        }

        bancarotta(giocatoreCorrente);
    }

    public int aggiornaPosizione(int risultatoDado) {
        this.posizione += risultatoDado;
        System.out.println("Il giocatore si muove fino alla posizione " + this.posizione);
        return this.posizione;
    }

    public int aggiornaPosizioneSePassaDalVia() {
        if (this.posizione >= 40) {
            this.posizione %= 40;
            this.portafoglio += 200;
            System.out.println("Il giocatore passa dal via e ritira 500 euro dalla banca");
        }
        return this.posizione;
    }

    public int aggiornaPosizioneSeInPrigione() {
        if (this.posizione == 30) {
            this.posizione = 10;
            System.out.println("Il giocatore va in prigione");
        }

        return this.posizione;
    }

    public int aggiornaPortafoglioSeAffitto(List<Casella> caselle, List<Contratto> contratti,
            Map<String, Giocatore> proprietariDeiContratti, Giocatore giocatoreCorrente) {

        String nomeProprieta = caselle.get(this.posizione).getTesto();

        if (proprietariDeiContratti.get(nomeProprieta) != giocatoreCorrente) {
            int numeroCasette = caselle.get(this.posizione).getNumeroDiCasetteSullaCasella();

            Optional<Contratto> contrattoOptional = contratti.stream()
                    .filter(contratto -> contratto.getTesto().equals(nomeProprieta)).findFirst();

            if (proprietariDeiContratti.get(nomeProprieta) != null) {
                int affitto = contrattoOptional.get().calcolaAffitto(numeroCasette);
                this.portafoglio -= affitto;
                System.out.println(
                        "Il giocatore ha pagato un affitto di " + affitto + " euro al proprietario del terreno");
                int portafoglioProprietarioDelContratto = proprietariDeiContratti.get(nomeProprieta).getPortafoglio();
                portafoglioProprietarioDelContratto = portafoglioProprietarioDelContratto + affitto;
            }
        }

        return this.portafoglio;
    }

    public void aggiornaPortafoglioSeTasse(Map<String, Giocatore> proprietariDeiContratti, Giocatore giocatoreCorrente,
            List<Casella> caselle, List<Contratto> contratti) {
        String nomeProprieta = caselle.get(this.posizione).getTesto();
        if (proprietariDeiContratti.get(nomeProprieta) != giocatoreCorrente) {
            if (caselle.get(this.posizione).getTesto().startsWith("Società")
                    || caselle.get(this.posizione).getTesto().startsWith("Stazione")) {
                int tassa = contratti.get(this.posizione).getTassa();
                this.portafoglio -= contratti.get(this.posizione).getTassa();
                System.out.println("Il giocatore paga una tassa di " + tassa + " euro");
            } else if (caselle.get(this.posizione).getTesto().startsWith("Tassa Patrimoniale")) {
                this.portafoglio -= 200;
                System.out.println("Il giocatore paga la tassa patrimoniale di 200 euro.");
            } else if (caselle.get(this.posizione).getTesto().startsWith("Tassa di Lusso")) {
                this.portafoglio -= 100;
                System.out.println("Il giocatore paga la tassa di lusso di 100 euro");
            }
        }
    }

    public void aggiornaPosizioneEPortafoglioSeProbabilita(List<Casella> caselle, List<Probabilita> probabilita,
            List<Probabilita> mazzoCartePescateProbabilita) {

        if (caselle.get(this.posizione).getTesto().equals("Probabilità")) {
            Probabilita probabilitaCorrente = probabilita.get(0);

            if (probabilita.get(0).getShiftPosizione() != 0) {
                this.posizione += probabilitaCorrente.getShiftPosizione();
            }

            if (Carta.eUnNumero(probabilitaCorrente.getNuovaPosizione())) {
                this.posizione = Integer.parseInt(probabilitaCorrente.getNuovaPosizione());
            }

            if (Carta.eUnNumero(probabilitaCorrente.getNuovaPosizione())
                    && Integer.parseInt(probabilitaCorrente.getNuovaPosizione()) > this.posizione
                    && !(probabilitaCorrente.getTesto().contains("senza passare dal Via"))) {
                this.portafoglio += 200;
            }

            this.portafoglio += probabilitaCorrente.getImporto();

            probabilitaCorrente.pescaCarta(probabilita, mazzoCartePescateProbabilita);
        }
    }

    public void aggiornaPosizioneEPortafoglioSeImprevisto(List<Casella> caselle, List<Imprevisto> imprevisti,
            List<Imprevisto> mazzoCartePescateImprevisti) {

        if (caselle.get(this.posizione).getTesto().equals("Imprevisti")) {
            Imprevisto imprevistoCorrente = imprevisti.get(0);

            if (imprevisti.get(0).getShiftPosizione() != 0) {
                this.posizione += imprevistoCorrente.getShiftPosizione();
            }

            if (Carta.eUnNumero(imprevistoCorrente.getNuovaPosizione())) {
                this.posizione = Integer.parseInt(imprevistoCorrente.getNuovaPosizione());
            }

            if (Carta.eUnNumero(imprevistoCorrente.getNuovaPosizione())
                    && Integer.parseInt(imprevistoCorrente.getNuovaPosizione()) > this.posizione
                    && !(imprevistoCorrente.getTesto().contains("senza passare dal Via"))) {
                this.portafoglio += 200;
            }

            this.portafoglio += imprevistoCorrente.getImporto();

            imprevistoCorrente.pescaCarta(imprevisti, mazzoCartePescateImprevisti);
        }
    }

    public void compraProprieta(Map<String, Giocatore> proprietariDeiContratti, List<Casella> caselle) {
        if (caselle.get(this.posizione).isTerreno()) {
            String nomeProprieta = caselle.get(this.posizione).getTesto();
            if (this.portafoglio >= caselle.get(this.posizione).getCostoProprieta()) {
                if (proprietariDeiContratti.containsKey(nomeProprieta)) {
                    proprietariDeiContratti.put(nomeProprieta, this);
                    this.portafoglio -= caselle.stream().filter(casella -> casella.getTesto().equals(nomeProprieta))
                            .findFirst()
                            .get().getCostoProprieta();
                    System.out.println("Il giocatore ha comprato la proprietà " + caselle.get(this.posizione).getTesto()
                            + " e ora ha un portafoglio di " + this.portafoglio + " euro");
                }
            }
        }

    }

    public int costruisciCasette(Map<String, Giocatore> proprietariDeiContratti, List<Casella> caselle) {

        int numeroDiCasetteSullaCasella = caselle.get(this.posizione).getNumeroDiCasetteSullaCasella();

        if (caselle.get(this.posizione).isTerreno()) {

            if (possiedeTutteLeProprietaDelColore(proprietariDeiContratti, caselle)) {

                if (numeroDiCasetteSullaCasella < 5) {

                    numeroDiCasetteSullaCasella++;

                    if (numeroDiCasetteSullaCasella > 4) {
                        System.out.println("Il giocatore corrente ha costruito un albergo, equivalente a "
                                + numeroDiCasetteSullaCasella + "casette sulla casella");
                    } else {
                        System.out.println(
                                "Il giocatore corrente ha costruito una nuova casetta. Attualmente il numero di casette sulla casella è di "
                                        + numeroDiCasetteSullaCasella + " casette");
                    }

                    caselle.get(this.posizione).setNumeroDiCasetteSullaCasella(numeroDiCasetteSullaCasella);

                }
            }

        }

        return numeroDiCasetteSullaCasella;
    }

    private Boolean possiedeTutteLeProprietaDelColore(Map<String, Giocatore> proprietariDeiContratti,
            List<Casella> caselle) {

        String coloreCasellaCorrente = caselle.get(this.posizione).getColore();

        List<String> nomiProprietaDelColore = caselle.stream()
                .filter(casella -> casella.getColore() != null && casella.getColore().equals(coloreCasellaCorrente))
                .map(Casella::getTesto)
                .collect(Collectors.toList());

        for (String nomeProprieta : nomiProprietaDelColore) {
            if (!proprietariDeiContratti.containsKey(nomeProprieta)
                    || proprietariDeiContratti.get(nomeProprieta) != this) {
                return false;
            }
        }

        return true;
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

    @Override
    public String toString() {
        return "Segnalino: " + segnalino + " Portafoglio: " + portafoglio + " Posizione: " + posizione;
    }
}