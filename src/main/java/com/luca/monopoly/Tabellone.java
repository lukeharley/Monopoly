package com.luca.monopoly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Tabellone {

	private final int NUMERO_MAX_PEZZI_CASA = 32;
	private final int NUMERO_MAX_PEZZI_ALBERGO = 12;

	private final List<Contratto> contratti = new ArrayList<>();
	private final List<Casella> caselle = new ArrayList<>();
	private final List<String> imprevisti = new ArrayList<>();
	private final List<String> probabilità = new ArrayList<>();
	private TreeMap<String, Giocatore> proprietariDeiContratti = new TreeMap<>();
	private Map<String, Integer> numeroDiCasetteSullaCasella = new HashMap<>();

	public Tabellone() {

		caselle.add(new Casella("Via", false, null, 0));
		caselle.add(new Casella("Vicolo Corto", true, "fucsia", 150));
		caselle.add(new Casella("Probabilità", false, null, 0));
		caselle.add(new Casella("Vicolo Stretto", true, "fucsia", 150));
		caselle.add(new Casella("Tassa Patrimoniale", false, null, 0));
		caselle.add(new Casella("Stazione Sud", false, null, 0));
		caselle.add(new Casella("Bastioni Gran Sasso", true, "azzurro", 250));
		caselle.add(new Casella("Imprevisti", false, null, 0));
		caselle.add(new Casella("Viale Monterosa", true, "azzurro", 250));
		caselle.add(new Casella("Viale Vesuvio", true, "azzurro", 300));
		caselle.add(new Casella("Prigione/Transito", false, null, 0));
		caselle.add(new Casella("Via Accademia", true, "arancione", 350));
		caselle.add(new Casella("Società Elettrica", false, null, 0));
		caselle.add(new Casella("Corso Ateneo", true, "arancione", 350));
		caselle.add(new Casella("Piazza Università", true, "arancione", 400));
		caselle.add(new Casella("Stazione Ovest", false, null, 0));
		caselle.add(new Casella("Via Verdi", true, "marrone", 450));
		caselle.add(new Casella("Probabilità", false, null, 0));
		caselle.add(new Casella("Corso Raffaello", true, "marrone", 450));
		caselle.add(new Casella("Piazza Dante", true, "marrone", 500));
		caselle.add(new Casella("Posteggio Gratuito", false, null, 0));
		caselle.add(new Casella("Via Marco Polo", true, "rosso", 550));
		caselle.add(new Casella("Imprevisti", false, null, 0));
		caselle.add(new Casella("Corso Magellano", true, "rosso", 550));
		caselle.add(new Casella("Largo Colombo", true, "rosso", 600));
		caselle.add(new Casella("Stazione Nord", false, null, 0));
		caselle.add(new Casella("Viale Costantino", true, "giallo", 650));
		caselle.add(new Casella("Viale Traiano", true, "giallo", 650));
		caselle.add(new Casella("Società Acqua Potabile", false, null, 0));
		caselle.add(new Casella("Piazza Giulio Cesare", true, "giallo", 700));
		caselle.add(new Casella("In prigione!", false, null, 0));
		caselle.add(new Casella("Via Roma", true, "verde", 750));
		caselle.add(new Casella("Corso Impero", true, "verde", 750));
		caselle.add(new Casella("Probabilità", false, null, 0));
		caselle.add(new Casella("Largo Augusto", true, "verde", 800));
		caselle.add(new Casella("Stazione Est", false, null, 0));
		caselle.add(new Casella("Imprevisti", false, null, 0));
		caselle.add(new Casella("Viale dei Giardini", true, "viola", 900));
		caselle.add(new Casella("Tassa di Lusso", false, null, 0));
		caselle.add(new Casella("Parco della Vittoria", true, "viola", 1000));

		contratti.add(new Contratto("Vicolo Corto", 5, 25, 0));
		contratti.add(new Contratto("Vicolo Stretto", 10, 50, 0));
		contratti.add(new Contratto("Stazione Sud", 0, 0, 65));
		contratti.add(new Contratto("Bastioni Gran Sasso", 15, 75, 0));
		contratti.add(new Contratto("Viale Monterosa", 15, 75, 0));
		contratti.add(new Contratto("Viale Vesuvio", 20, 100, 0));
		contratti.add(new Contratto("Via Accademia", 25, 125, 0));
		contratti.add(new Contratto("Società Elettrica", 0, 0, 50));
		contratti.add(new Contratto("Corso Ateneo", 25, 125, 0));
		contratti.add(new Contratto("Piazza Università", 30, 150, 0));
		contratti.add(new Contratto("Stazione Ovest", 0, 0, 65));
		contratti.add(new Contratto("Via Verdi", 35, 175, 0));
		contratti.add(new Contratto("Corso Raffaello", 35, 175, 0));
		contratti.add(new Contratto("Piazza Dante", 40, 200, 0));
		contratti.add(new Contratto("Via Marco Polo", 45, 225, 0));
		contratti.add(new Contratto("Corso Magellano", 45, 225, 0));
		contratti.add(new Contratto("Largo Colombo", 50, 250, 0));
		contratti.add(new Contratto("Stazione Nord", 0, 0, 65));
		contratti.add(new Contratto("Viale Costantino", 50, 250, 0));
		contratti.add(new Contratto("Viale Traiano", 55, 275, 0));
		contratti.add(new Contratto("Società Acqua Potabile", 0, 0, 50));
		contratti.add(new Contratto("Piazza Giulio Cesare", 60, 300, 0));
		contratti.add(new Contratto("Via Roma", 65, 325, 0));
		contratti.add(new Contratto("Corso Impero", 70, 375, 0));
		contratti.add(new Contratto("Largo Augusto", 70, 375, 0));
		contratti.add(new Contratto("Stazione Est", 0, 0, 65));
		contratti.add(new Contratto("Viale dei Giardini", 75, 425, 0));
		contratti.add(new Contratto("Parco della Vittoria", 125, 500, 0));

		imprevisti.add("Andate sino al Largo Colombo: se passate dal Via ritirate 500€.");
		imprevisti.add("Andate in Prigione direttamente e senza passare dal Via.");
		imprevisti.add("Avete tutti i vostri stabili da riparare: pagare 60€ per ogni Casa e 250€ per ogni Albergo.");
		imprevisti.add("Fate 3 passi indietro (con tanti auguri).");
		imprevisti.add("Andate sino a Via Accademia: se passate dal Via ritirate 500€.");
		imprevisti.add("Versate 50€ per beneficienza.");
		imprevisti.add("Andate alla Stazione Nord: se passate dal Via ritirate 500€.");
		imprevisti.add("Multa di 40€ per aver guidato senza patente.");
		imprevisti.add("Andate fino al Parco della Vittoria.");
		imprevisti.add("Matrimonio in famiglia: spese impreviste 375€.");
		imprevisti.add(
				"Uscite gratis di prigione, se ci siete: potete conservare questo cartoncino sino al momento di servirvene (non si sa mai!) oppure venderlo.");
		imprevisti.add("Maturano le cedole delle vostre cartelle di rendita, ritirate 375€.");
		imprevisti.add("La banca vi paga gli interessi del vostro conto corrente, ritirate 125€.");
		imprevisti.add("Andate avanti sino al Via.");
		imprevisti.add("Avete vinto un terno al lotto: ritirate 250€.");
		imprevisti.add("Andate in prigione direttamente e senza passare dal Via.");

		probabilità.add("Ritornate al Vicolo Corto.");
		probabilità.add("È maturata la cedola delle vostre azioni: ritirate 60€.");
		probabilità.add("Rimborso tassa sul reddito: ritirate 50€ dalla banca.");
		probabilità.add("Avete vinto il secondo premio in un concorso di bellezza: ritirate 25€.");
		probabilità.add("Scade il vostro premio di assicurazione: pagate 125€.");
		probabilità.add(
				"Uscite gratis di prigione, se ci siete: potete conservare questo cartoncino sino al momento di servirvene(non si sa mai!) oppure venderlo.");
		probabilità.add("Avete vinto un premio di consolazione alla lotteria di Merano: ritirate 250€.");
		probabilità.add("Andate fino al Via.");
		probabilità.add("Pagate una multa di 25€, oppure prendete un cartoncino dagli Imprevisti.");
		probabilità.add("Siete creditori verso la banca di 500€, ritirateli.");
		probabilità.add("Avete perso una causa: pagate 250€");
		probabilità.add("Andate in prigione direttamente e senza passare dal Via.");
		probabilità.add("È il vostro compleanno: ogni giocatore vi regala 25€.");
		probabilità.add(
				"Dovete pagare un contributo di miglioria stradale, 100€ per ogni Casa, 250€ per ogni Albergo che possedete.");
		probabilità.add("Avete ceduto delle azioni: ricavate 125€.");
		probabilità.add("Pagate il conto del dottore: 125€.");

		proprietariDeiContratti.put("Vicolo Corto", null);
		proprietariDeiContratti.put("Vicolo Stretto", null);
		proprietariDeiContratti.put("Stazione Sud", null);
		proprietariDeiContratti.put("Bastioni Gran Sasso", null);
		proprietariDeiContratti.put("Viale Monterosa", null);
		proprietariDeiContratti.put("Viale Vesuvio", null);
		proprietariDeiContratti.put("Via Accademia", null);
		proprietariDeiContratti.put("Società Elettrica", null);
		proprietariDeiContratti.put("Corso Ateneo", null);
		proprietariDeiContratti.put("Piazza Università", null);
		proprietariDeiContratti.put("Stazione Ovest", null);
		proprietariDeiContratti.put("Via Verdi", null);
		proprietariDeiContratti.put("Corso Raffaello", null);
		proprietariDeiContratti.put("Piazza Dante", null);
		proprietariDeiContratti.put("Via Marco Polo", null);
		proprietariDeiContratti.put("Corso Magellano", null);
		proprietariDeiContratti.put("Largo Colombo", null);
		proprietariDeiContratti.put("Stazione Nord", null);
		proprietariDeiContratti.put("Viale Costantino", null);
		proprietariDeiContratti.put("Viale Traiano", null);
		proprietariDeiContratti.put("Società Acqua Potabile", null);
		proprietariDeiContratti.put("Piazza Giulio Cesare", null);
		proprietariDeiContratti.put("Via Roma", null);
		proprietariDeiContratti.put("Corso Impero", null);
		proprietariDeiContratti.put("Largo Augusto", null);
		proprietariDeiContratti.put("Stazione Est", null);
		proprietariDeiContratti.put("Viale dei Giardini", null);
		proprietariDeiContratti.put("Parco della Vittoria", null);

		numeroDiCasetteSullaCasella.put("Vicolo Corto", 0);
		numeroDiCasetteSullaCasella.put("Vicolo Stretto", 0);
		numeroDiCasetteSullaCasella.put("Stazione Sud", 0);
		numeroDiCasetteSullaCasella.put("Bastioni Gran Sasso", 0);
		numeroDiCasetteSullaCasella.put("Viale Monterosa", 0);
		numeroDiCasetteSullaCasella.put("Viale Vesuvio", 0);
		numeroDiCasetteSullaCasella.put("Via Accademia", 0);
		numeroDiCasetteSullaCasella.put("Società Elettrica", 0);
		numeroDiCasetteSullaCasella.put("Corso Ateneo", 0);
		numeroDiCasetteSullaCasella.put("Piazza Università", 0);
		numeroDiCasetteSullaCasella.put("Stazione Ovest", 0);
		numeroDiCasetteSullaCasella.put("Via Verdi", 0);
		numeroDiCasetteSullaCasella.put("Corso Raffaello", 0);
		numeroDiCasetteSullaCasella.put("Piazza Dante", 0);
		numeroDiCasetteSullaCasella.put("Via Marco Polo", 0);
		numeroDiCasetteSullaCasella.put("Corso Magellano", 0);
		numeroDiCasetteSullaCasella.put("Largo Colombo", 0);
		numeroDiCasetteSullaCasella.put("Stazione Nord", 0);
		numeroDiCasetteSullaCasella.put("Viale Costantino", 0);
		numeroDiCasetteSullaCasella.put("Viale Traiano", 0);
		numeroDiCasetteSullaCasella.put("Società Acqua Potabile", 0);
		numeroDiCasetteSullaCasella.put("Piazza Giulio Cesare", 0);
		numeroDiCasetteSullaCasella.put("Via Roma", 0);
		numeroDiCasetteSullaCasella.put("Corso Impero", 0);
		numeroDiCasetteSullaCasella.put("Largo Augusto", 0);
		numeroDiCasetteSullaCasella.put("Stazione Est", 0);
		numeroDiCasetteSullaCasella.put("Viale dei Giardini", 0);
		numeroDiCasetteSullaCasella.put("Parco della Vittoria", 0);

	}

	public List<Casella> getCaselle() {
		return caselle;
	}

	public List<Contratto> getContratti() {
		return contratti;
	}

	public List<String> getImprevisti() {
		return imprevisti;
	}

	public List<String> getProbabilità() {
		return probabilità;
	}

	public Map<String, Giocatore> getProprietariDeiContratti() {
		return proprietariDeiContratti;
	}

	public void setProprietariDeiContratti(TreeMap<String, Giocatore> proprietariDeiContratti) {
		this.proprietariDeiContratti = proprietariDeiContratti;
	}

	public Map<String, Integer> getNumeroDiCasetteSullaCasella() {
		return numeroDiCasetteSullaCasella;
	}

	public void setNumeroDiCasetteSullaCasella(Map<String, Integer> numeroDiCasetteSullaCasella) {
		this.numeroDiCasetteSullaCasella = numeroDiCasetteSullaCasella;
	}

	public List<Casa> getCase() {

		List<Casa> listaDiCase = new ArrayList<>();

		for (int i = 1; i <= NUMERO_MAX_PEZZI_CASA; i++) {
			listaDiCase.add(new Casa());
		}

		return listaDiCase;
	}

	public List<Albergo> getAlberghi() {

		List<Albergo> listaDiAlberghi = new ArrayList<>();

		for (int i = 1; i <= NUMERO_MAX_PEZZI_ALBERGO; i++) {
			listaDiAlberghi.add(new Albergo());
		}

		return listaDiAlberghi;
	}

}
