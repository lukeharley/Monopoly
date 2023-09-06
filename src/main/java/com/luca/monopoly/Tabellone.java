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

		List<Contratto> contratti = new ArrayList(); 

		//TODO convertire da lire in euro 
		contratti.add(new Contratto("Vicolo Corto", 200, 1000));
		contratti.add(new Contratto("Vicolo Stretto", 400, 2000));
		contratti.add(new Contratto("Stazione Sud", 0, 0));
		contratti.add(new Contratto("Bastioni Gran Sasso", 600, 3000));
		contratti.add(new Contratto("Viale Monterosa", 600, 3000));
		contratti.add(new Contratto("Viale Vesuvio", 800, 4000));
		contratti.add(new Contratto("Via Accademia", 1000, 5000));
		contratti.add(new Contratto("Società Elettrica", 0, 0));
		contratti.add(new Contratto("Corso Ateneo", 1000, 5000));
		contratti.add(new Contratto("Piazza Università", 1200, 6000));
		contratti.add(new Contratto("Stazione Ovest", 0, 0));
		contratti.add(new Contratto("Via Verdi", 1400, 7000));
		contratti.add(new Contratto("Corso Raffaello", 1400, 7000));
		contratti.add(new Contratto("Piazza Dante", 1600, 8000));
		contratti.add(new Contratto("Via Marco Polo", 1800, 9000));
		contratti.add(new Contratto("Corso Magellano", 1800, 9000));
		contratti.add(new Contratto("Largo Colombo", 2000, 10000));
		contratti.add(new Contratto("Stazione Nord", 0, 0));
		contratti.add(new Contratto("Viale Costantino", 2000, 10000));
		contratti.add(new Contratto("Viale Traiano", 2200, 11000));
		contratti.add(new Contratto("Società Acqua Potabile", 0, 0));
		contratti.add(new Contratto("Piazza Giulio Cesare", 2400, 12000));
		contratti.add(new Contratto("Via Roma", 2600, 13000));
		contratti.add(new Contratto("Corso Impero", 2700, 14000));
		contratti.add(new Contratto("Largo Augusto", 2800, 15000));
		contratti.add(new Contratto("Stazione Est", 0, 0));
		contratti.add(new Contratto("Viale dei Giardini", 3000, 17000));
		contratti.add(new Contratto("Parco della Vittoria", 5000, 20000));
		

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


VICOLO CORTO
Questo contratto vale: 6.000 Rendita solo terreno: 200 Con 1 casa: 1.000 Con 2 case: 3.000 Con 3 case: 9.000 Con 4 case: 16.000 Con Albergo: 25.000 Se un giocattore possiedetutti i terrenid!uno stesso gruppo " colore #$ la rendita del solo terreno viene raddoppiata. Costo: di ogni casa: 5.000 di ogni albergo: 5.000 %alore ipotecario: 3.000
VICOLO STRETTO
Questo contratto vale: 6.000 Rendita solo terreno: 400 Con 1 casa: 2.000 Con 2 case: 6.000 Con 3 case: 1&.000 Con 4 case: 32.000 Con Albergo: 45.000 Se un giocattore possiedetutti i terrenid!uno stesso gruppo " colore #$ la rendita del solo terreno viene raddoppiata. Costo: di ogni casa: 5.000 di ogni albergo: 5.000 %alore ipotecario: 3.000
STAZIONE SUD
Questo contratto vale: 20.000 Rendita: 2.500 Se si possiedono 2 Sta'ioni: 5.000 Se si possiedono 3 Sta'ioni: 10.000 Se si possiedono 4 Sta'ioni: 20.000 %alore ipotecario: 10.000
BASTIONI GRAN SASSO
Questo contratto vale: 10.000 Rendita solo terreno: 600 Con 1 casa: 3.000 Con 2 case: 9.000 Con 3 case: 2(.000 Con 4 case: 40.000 Con Albergo: 55.000 Se un giocattore possiedetutti i terrenid!uno stesso gruppo " colore #$ la rendita del solo terreno viene raddoppiata. Costo: di ogni casa: 5.000 di ogni albergo: 5.000 %alore ipotecario: 5.000
VIALE MONTEROSA
Questo contratto vale: 10.000 Rendita solo terreno: 600 Con 1 casa: 3.000 Con 2 case: 9.000 Con 3 case: 2(.000 Con 4 case: 40.000 Con Albergo: 55.000 Se un giocattore possiedetutti i terrenid!uno stesso gruppo " colore #$ la rendita del solo terreno viene raddoppiata. Costo: di ogni casa: 5.000 di ogni albergo: 5.000 %alore ipotecario: 5.000
VIALE VESUVIO
Questo contratto vale: 12.000 Rendita solo terreno: &00 Con 1 casa: 4.000 Con 2 case: 10.000 Con 3 case: 30.000 Con 4 case: 45.000 Con Albergo: 60.000 Se un giocattore possiedetutti i terrenid!uno stesso gruppo " colore #$ la rendita del solo terreno viene raddoppiata. Costo: di ogni casa: 5.000 di ogni albergo: 5.000 %alore ipotecario: 6.000
VIA ACCADEMIA
Questo contratto vale: 14.000 Rendita solo terreno: 1.000 Con 1 casa: 5.000 Con 2 case: 15.000 Con 3 case: 45.000 Con 4 case: 62.000 Con Albergo: (5.000 Se un giocattore possiedetutti i terrenid!uno stesso gruppo " colore #$ la rendita del solo terreno viene raddoppiata. Costo: di ogni casa: 10.000 di ogni albergo: 10.000
SOCIETA ELETTRICA
Questo contratto vale: 15.000 Rendita: 2.000 Se si possiede anc)e l! Ac*ua +otabile: 10.000 %alore ipotecario: (.500
CORSO ATENEO
Questo contratto vale: 14.000 Rendita solo terreno: 1.000 Con 1 casa: 5.000 Con 2 case: 15.000 Con 3 case: 45.000 Con 4 case: 62.000 Con Albergo: (5.000 Se un giocattore possiedetutti i terrenid!uno stesso gruppo " colore #$ la rendita del solo terreno viene raddoppiata. Costo: di ogni casa: 10.000 di ogni albergo: 10.000

*/