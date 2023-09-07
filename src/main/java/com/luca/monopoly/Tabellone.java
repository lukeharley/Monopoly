package com.luca.monopoly;
import java.util.ArrayList;
import java.util.List;
public class Tabellone { 
	
	public List<Casella> getCaselle() {
		
		List<Casella> caselle = new ArrayList<>();
		
		caselle.add(new Casella("Via", false, null));
		caselle.add(new Casella("Vicolo Corto", true, "fucsia"));
		caselle.add(new Casella("Probabilità", false, null));
		caselle.add(new Casella("Vicolo Stretto", true, "fucsia"));
		caselle.add(new Casella("Tassa Patrimoniale", false, null));
		caselle.add(new Casella("Stazione Sud", false, null));
		caselle.add(new Casella("Bastioni Gran Sasso", true, "azzurro"));
		caselle.add(new Casella("Imprevisti", false, null));
		caselle.add(new Casella("Viale Monterosa", true, "azzurro"));
		caselle.add(new Casella("Viale Vesuvio", true, "azzurro"));
		caselle.add(new Casella("Prigione/Transito", false, null));
		caselle.add(new Casella("Via Accademia", true, "arancione"));
		caselle.add(new Casella("Società Elettrica", false, null));
		caselle.add(new Casella("Corso Ateneo", true, "arancione"));
		caselle.add(new Casella("Piazza Università", true, "arancione"));
		caselle.add(new Casella("Stazione Ovest", false, null));
		caselle.add(new Casella("Via Verdi", true, "marrone"));
		caselle.add(new Casella("Probabilità", false, null));
		caselle.add(new Casella("Corso Raffaello", true, "marrone"));
		caselle.add(new Casella("Piazza Dante", true, "marrone"));
		caselle.add(new Casella("Posteggio Gratuito", false, null));
		caselle.add(new Casella("Via Marco Polo", true, "rosso"));
		caselle.add(new Casella("Imprevisti", false, null));
		caselle.add(new Casella("Corso Magellano", true, "rosso"));
		caselle.add(new Casella("Largo Colombo", true, "rosso"));
		caselle.add(new Casella("Stazione Nord", false, null));
		caselle.add(new Casella("Viale Costantino", true, "giallo"));
		caselle.add(new Casella("Viale Traiano", true, "giallo"));
		caselle.add(new Casella("Società Acqua Potabile", false, null));
		caselle.add(new Casella("Piazza Giulio Cesare", true, "giallo"));
		caselle.add(new Casella("In prigione!", false, null));
		caselle.add(new Casella("Via Roma", true, "verde"));		
		caselle.add(new Casella("Corso Impero", true, "verde"));
		caselle.add(new Casella("Probabilità", false, null));
		caselle.add(new Casella("Largo Augusto", true, "verde"));
		caselle.add(new Casella("Stazione Est", false, null));
		caselle.add(new Casella("Imprevisti", false, null));
		caselle.add(new Casella("Viale dei Giardini", true, "viola"));
		caselle.add(new Casella("Tassa di Lusso", false, null));
		caselle.add(new Casella("Parco della Vittoria", true, "viola"));

		return caselle;
	}

	public List<Contratto> getContratti() {

		List<Contratto> contratti = new ArrayList<>(); 

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
		

		return contratti; 
	}

	public List<String> getImprevisti() {

		List<String> imprevisti = new ArrayList<>();

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
		imprevisti.add("Uscite gratis di prigione, se ci siete: potete conservare questo cartoncino sino al momento di servirvene (non si sa mai!) oppure venderlo.");
		imprevisti.add("Maturano le cedole delle vostre cartelle di rendita, ritirate 375€.");
		imprevisti.add("La banca vi paga gli interessi del vostro conto corrente, ritirate 125€.");
		imprevisti.add("Andate avanti sino al Via.");
		imprevisti.add("Avete vinto un terno al lotto: ritirate 250€.");
		imprevisti.add("Andate in prigione direttamente e senza passare dal Via.");

		return imprevisti;

	} 

	public List<String> getProbabilità() {

		List<String> probabilità = new ArrayList<>();

		probabilità.add("Ritornate al Vicolo Corto.");
		probabilità.add("È maturata la cedola delle vostre azioni: ritirate 60€.");
		probabilità.add("Rimborso tassa sul reddito: ritirate 50€ dalla banca.");
		probabilità.add("Avete vinto il secondo premio in un concorso di bellezza: ritirate 25€.");
		probabilità.add("Scade il vostro premio di assicurazione: pagate 125€.");
		probabilità.add("Uscite gratis di prigione, se ci siete: potete conservare questo cartoncino sino al momento di servirvene(non si sa mai!) oppure venderlo.");
		probabilità.add("Avete vinto un premio di consolazione alla lotteria di Merano: ritirate 250€.");
		probabilità.add("Andate fino al Via.");
		probabilità.add("Pagate una multa di 25€, oppure prendete un cartoncino dagli Imprevisti.");
		probabilità.add("Siete creditori verso la banca di 500€, ritirateli.");
		probabilità.add("Avete perso una causa: pagate 250€");
		probabilità.add("Andate in prigione direttamente e senza passare dal Via.");
		probabilità.add("È il vostro compleanno: ogni giocatore vi regala 25€.");
		probabilità.add("Dovete pagare un contributo di miglioria stradale, 100€ per ogni Casa, 250€ per ogni Albergo che possedete.");
		probabilità.add("Avete ceduto delle azioni: ricavate 125€.");
		probabilità.add("Pagate il conto del dottore: 125€.");

		return probabilità;

	} 
}


/* fonti: 
tabellone: https://it.wikipedia.org/wiki/Monopoly#:~:text=Giochi%20(in%20euro)-,Posteggio%20gratuito,-Via%20Marco%20Polo 
imprevisti e probabilità: https://answerprime.com/monopoli-elenco-imprevisti-probabilita10pt-2/ 
contratti (campione): https://it.scribd.com/document/327938771/Contratti-Monopoli 
https://www.giochi-da-tavolo.it/monpoli-istruzioni-regole/#:~:text=PAGARE%20RENDITE%20E%20AFFITTI
*/