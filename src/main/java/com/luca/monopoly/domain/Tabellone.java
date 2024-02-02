package com.luca.monopoly.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Tabellone {

	private final int NUMERO_MAX_PEZZI_CASETTA = 32;
	private final int NUMERO_MAX_PEZZI_ALBERGO = 12;

	private final List<Contratto> contratti = new ArrayList<>();
	private final List<Casella> caselle = new ArrayList<>();
	private final List<Imprevisto> imprevisti = new ArrayList<>();
	private final List<Probabilita> probabilita = new ArrayList<>();
	private TreeMap<String, Giocatore> proprietariDeiContratti = new TreeMap<>();

	public Tabellone() {

		caselle.add(new Casella("Via", false, null, 0, 0));
		caselle.add(new Casella("Vicolo Corto", true, "fucsia", 150, 0));
		caselle.add(new Casella("Probabilità", false, null, 0, 0));
		caselle.add(new Casella("Vicolo Stretto", true, "fucsia", 150, 0));
		caselle.add(new Casella("Tassa Patrimoniale", false, null, 0, 0));
		caselle.add(new Casella("Stazione Sud", false, null, 0, 0));
		caselle.add(new Casella("Bastioni Gran Sasso", true, "azzurro", 250, 0));
		caselle.add(new Casella("Imprevisti", false, null, 0, 0));
		caselle.add(new Casella("Viale Monterosa", true, "azzurro", 250, 0));
		caselle.add(new Casella("Viale Vesuvio", true, "azzurro", 300, 0));
		caselle.add(new Casella("Prigione/Transito", false, null, 0, 0));
		caselle.add(new Casella("Via Accademia", true, "arancione", 350, 0));
		caselle.add(new Casella("Società Elettrica", false, null, 0, 0));
		caselle.add(new Casella("Corso Ateneo", true, "arancione", 350, 0));
		caselle.add(new Casella("Piazza Università", true, "arancione", 400, 0));
		caselle.add(new Casella("Stazione Ovest", false, null, 0, 0));
		caselle.add(new Casella("Via Verdi", true, "marrone", 450, 0));
		caselle.add(new Casella("Probabilità", false, null, 0, 0));
		caselle.add(new Casella("Corso Raffaello", true, "marrone", 450, 0));
		caselle.add(new Casella("Piazza Dante", true, "marrone", 500, 0));
		caselle.add(new Casella("Posteggio Gratuito", false, null, 0, 0));
		caselle.add(new Casella("Via Marco Polo", true, "rosso", 550, 0));
		caselle.add(new Casella("Imprevisti", false, null, 0, 0));
		caselle.add(new Casella("Corso Magellano", true, "rosso", 550, 0));
		caselle.add(new Casella("Largo Colombo", true, "rosso", 600, 0));
		caselle.add(new Casella("Stazione Nord", false, null, 0, 0));
		caselle.add(new Casella("Viale Costantino", true, "giallo", 650, 0));
		caselle.add(new Casella("Viale Traiano", true, "giallo", 650, 0));
		caselle.add(new Casella("Società Acqua Potabile", false, null, 0, 0));
		caselle.add(new Casella("Piazza Giulio Cesare", true, "giallo", 700, 0));
		caselle.add(new Casella("In prigione!", false, null, 0, 0));
		caselle.add(new Casella("Via Roma", true, "verde", 750, 0));
		caselle.add(new Casella("Corso Impero", true, "verde", 750, 0));
		caselle.add(new Casella("Probabilità", false, null, 0, 0));
		caselle.add(new Casella("Largo Augusto", true, "verde", 800, 0));
		caselle.add(new Casella("Stazione Est", false, null, 0, 0));
		caselle.add(new Casella("Imprevisti", false, null, 0, 0));
		caselle.add(new Casella("Viale dei Giardini", true, "viola", 900, 0));
		caselle.add(new Casella("Tassa di Lusso", false, null, 0, 0));
		caselle.add(new Casella("Parco della Vittoria", true, "viola", 1000, 0));

		contratti.add(new Contratto("Vicolo Corto", 5, 25, 0, 0));
		contratti.add(new Contratto("Vicolo Stretto", 10, 50, 0, 0));
		contratti.add(new Contratto("Stazione Sud", 0, 0, 65, 60));
		contratti.add(new Contratto("Bastioni Gran Sasso", 15, 75, 0, 0));
		contratti.add(new Contratto("Viale Monterosa", 15, 75, 0, 0));
		contratti.add(new Contratto("Viale Vesuvio", 20, 100, 0, 0));
		contratti.add(new Contratto("Via Accademia", 25, 125, 0, 0));
		contratti.add(new Contratto("Società Elettrica", 0, 0, 50, 50));
		contratti.add(new Contratto("Corso Ateneo", 25, 125, 0, 0));
		contratti.add(new Contratto("Piazza Università", 30, 150, 0, 0));
		contratti.add(new Contratto("Stazione Ovest", 0, 0, 65, 60));
		contratti.add(new Contratto("Via Verdi", 35, 175, 0, 0));
		contratti.add(new Contratto("Corso Raffaello", 35, 175, 0, 0));
		contratti.add(new Contratto("Piazza Dante", 40, 200, 0, 0));
		contratti.add(new Contratto("Via Marco Polo", 45, 225, 0, 0));
		contratti.add(new Contratto("Corso Magellano", 45, 225, 0, 0));
		contratti.add(new Contratto("Largo Colombo", 50, 250, 0, 0));
		contratti.add(new Contratto("Stazione Nord", 0, 0, 65, 60));
		contratti.add(new Contratto("Viale Costantino", 50, 250, 0, 0));
		contratti.add(new Contratto("Viale Traiano", 55, 275, 0, 0));
		contratti.add(new Contratto("Società Acqua Potabile", 0, 0, 50, 50));
		contratti.add(new Contratto("Piazza Giulio Cesare", 60, 300, 0, 0));
		contratti.add(new Contratto("Via Roma", 65, 325, 0, 0));
		contratti.add(new Contratto("Corso Impero", 70, 375, 0, 0));
		contratti.add(new Contratto("Largo Augusto", 70, 375, 0, 0));
		contratti.add(new Contratto("Stazione Est", 0, 0, 65, 60));
		contratti.add(new Contratto("Viale dei Giardini", 75, 425, 0, 0));
		contratti.add(new Contratto("Parco della Vittoria", 125, 500, 0, 0));

		// prettier-ignore
		imprevisti.add(new Imprevisto("Andate sino al Largo Colombo: se passate dal Via ritirate 500€.", 0, "24", 0));
		imprevisti.add(new Imprevisto("Andate in Prigione direttamente e senza passare dal Via.", 0, "30", 0));
		imprevisti.add(new Imprevisto("Avete tutti i vostri stabili da riparare: pagare 180€.", -180, "NaN", 0));
		/*
		 * da implementare, sostituito con imprevisto precedente in attesa di gestire il
		 * numero di case o alberghi posseduti:
		 * imprevisti.add(new Imprevisto(
		 * "Avete tutti i vostri stabili da riparare: pagare 60€ per ogni Casa e 250€ per ogni Albergo."
		 * , 60 / 250,
		 * "NaN", 0));
		 */
		imprevisti.add(new Imprevisto("Fate 3 passi indietro (con tanti auguri).", 0, "NaN", -3));
		imprevisti.add(new Imprevisto("Andate sino a Via Accademia: se passate dal Via ritirate 500€.", 0, "11", 0));
		imprevisti.add(new Imprevisto("Versate 50€ per beneficienza.", -50, "NaN", 0));
		imprevisti.add(new Imprevisto("Andate alla Stazione Nord: se passate dal Via ritirate 500€.", 0, "25", 0));
		imprevisti.add(new Imprevisto("Multa di 40€ per aver guidato senza patente.", -40, "NaN", 0));
		imprevisti.add(new Imprevisto("Andate fino al Parco della Vittoria.", 0, "40", 0));
		imprevisti.add(new Imprevisto("Matrimonio in famiglia: spese impreviste 375€.", -375, "NaN", 0));
		imprevisti.add(new Imprevisto("Matrimonio in famiglia: spese impreviste 280€.", -280, "NaN", 0));
		/*
		 * da implementare, sostituito con imprevisto precedente in attesa di gestire
		 * l'uscita di prigione
		 * imprevisti.add(new Imprevisto(
		 * "Uscite gratis di prigione, se ci siete: potete conservare questo cartoncino sino al momento di servirvene (non si sa mai!) oppure venderlo."
		 * ,
		 * 0, "NaN", 0));
		 */
		imprevisti.add(new Imprevisto("Maturano le cedole delle vostre cartelle di rendita, ritirate 375€.", 375, "NaN",
				0));
		imprevisti.add(
				new Imprevisto("La banca vi paga gli interessi del vostro conto corrente, ritirate 125€.", 125, "NaN",
						0));
		imprevisti.add(new Imprevisto("Andate avanti sino al Via.", 500, "0", 0));
		imprevisti.add(new Imprevisto("Avete vinto un terno al lotto: ritirate 250€.", 250, "NaN", 0));
		imprevisti.add(new Imprevisto("Andate in prigione direttamente e senza passare dal Via.", 0, "30", 0));

		probabilita.add(new Probabilita("Ritornate al Vicolo Corto.", 0, "1", 0));
		probabilita.add(new Probabilita("È maturata la cedola delle vostre azioni: ritirate 60€.", 60, "NaN", 0));
		probabilita.add(new Probabilita("Rimborso tassa sul reddito: ritirate 50€ dalla banca.", 50, "NaN", 0));
		probabilita.add(new Probabilita("Avete vinto il secondo premio in un concorso di bellezza: ritirate 25€.", 25,
				"NaN", 0));
		probabilita.add(new Probabilita("Scade il vostro premio di assicurazione: pagate 125€.", -125, "NaN", 0));
		probabilita.add(new Probabilita("Scade il vostro premio di assicurazione: pagate 140€.", -140, "NaN", 0));
		/*
		 * da implementare, sostituito con probabilità precedente in attesa di gestire
		 * l'uscita di prigione
		 * probabilita.add(new Probabilita(
		 * "Uscite gratis di prigione, se ci siete: potete conservare questo cartoncino sino al momento di servirvene(non si sa mai!) oppure venderlo."
		 * ,
		 * 0, "NaN", 0));
		 */
		probabilita.add(new Probabilita("Avete vinto un premio di consolazione alla lotteria di Merano: ritirate 250€.",
				250, "NaN", 0));
		probabilita.add(new Probabilita("Andate fino al Via.", 0, "0", 0));
		// seconda parte ancora da implementare
		probabilita
				.add(new Probabilita("Pagate una multa di 25€ (oppure pescate una carta Imprevisti)", -25, "NaN", 0));
		probabilita.add(new Probabilita("Siete creditori verso la banca di 500€, ritirateli.", 500, "NaN", 0));
		probabilita.add(new Probabilita("Avete perso una causa: pagate 250€", -250, "NaN", 0));
		probabilita.add(new Probabilita("Andate in prigione direttamente e senza passare dal Via.", 0, "30", 0));
		// va bene finché i giocatori sono 2
		probabilita.add(new Probabilita("È il vostro compleanno: ogni giocatore vi regala 25€.", 25, "NaN", 0));
		probabilita.add(new Probabilita("Avete perso una causa: pagate 150€", -150, "NaN", 0));
		/*
		 * da implementare, sostituito con probabilità precedente in attesa di gestire
		 * il
		 * numero di case o alberghi posseduti:
		 * probabilita.add(new Probabilita(
		 * "Dovete pagare un contributo di miglioria stradale, 100€ per ogni Casa, 250€ per ogni Albergo che possedete."
		 * ,
		 * (100 * 1) + (250 * 1), "NaN", 0));
		 */
		probabilita.add(new Probabilita("Avete ceduto delle azioni: ricavate 125€.", 125, "NaN", 0));
		probabilita.add(new Probabilita("Pagate il conto del dottore: 125€.", -125, "NaN", 0));

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

	}

	public List<Casella> getCaselle() {
		return caselle;
	}

	public List<Contratto> getContratti() {
		return contratti;
	}

	public List<Imprevisto> getImprevisti() {
		return imprevisti;
	}

	public List<Probabilita> getProbabilita() {
		return probabilita;
	}

	public Map<String, Giocatore> getProprietariDeiContratti() {
		return proprietariDeiContratti;
	}

	public void setProprietariDeiContratti(TreeMap<String, Giocatore> proprietariDeiContratti) {
		this.proprietariDeiContratti = proprietariDeiContratti;
	}

	public List<Casetta> getCasette() {

		List<Casetta> listaDiCasette = new ArrayList<>();

		for (int i = 1; i <= NUMERO_MAX_PEZZI_CASETTA; i++) {
			listaDiCasette.add(new Casetta());
		}

		return listaDiCasette;
	}

	public List<Albergo> getAlberghi() {

		List<Albergo> listaDiAlberghi = new ArrayList<>();

		for (int i = 1; i <= NUMERO_MAX_PEZZI_ALBERGO; i++) {
			listaDiAlberghi.add(new Albergo());
		}

		return listaDiAlberghi;
	}

}
