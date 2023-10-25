package com.luca.monopoly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MonopolyTest {

	private Monopoly monopoly = new Monopoly();

	@BeforeEach
	void setup() {
		monopoly = new Monopoly();
	}

	@Test
	void test_inizializzazione_monopoly() {

		assertNotNull(monopoly);

	}

	@Test
	void test_caselle() {

		Tabellone tabellone = monopoly.getTabellone();

		List<Casella> caselle = tabellone.getCaselle();
		assertEquals(40, caselle.size());

		Casella primaCasella = caselle.get(0);
		assertEquals("Via", primaCasella.getTesto());
		assertFalse(primaCasella.isTerreno());
		assertNull(primaCasella.getColore());

		Casella secondaCasella = caselle.get(1);
		assertEquals("Vicolo Corto", secondaCasella.getTesto());
		assertTrue(secondaCasella.isTerreno());
		assertEquals("fucsia", secondaCasella.getColore());

	}

	@Test
	void test_segnalini() {

		List<Segnalini> segnalini = monopoly.getSegnalini();
		assertEquals(8, segnalini.size());

	}

	@Test
	void test_contratti() {

		Tabellone tabellone = monopoly.getTabellone();

		List<Contratto> contratti = tabellone.getContratti();
		assertEquals(28, contratti.size());

		assertEquals("Vicolo Corto", contratti.get(0).getTesto());
		assertEquals(10, contratti.get(1).getRenditaTerreno());
		assertEquals(500, contratti.get(27).getRenditaUnaCasa());
		assertEquals(1000, contratti.get(13).getRenditaAlbergo());
		assertEquals(65, contratti.get(2).getRenditaUnaStazione());
		assertEquals(130, contratti.get(2).getRenditaDueStazioni());

	}

	@Test
	void test_imprevisti() {

		Tabellone tabellone = monopoly.getTabellone();

		List<String> imprevisti = tabellone.getImprevisti();
		assertEquals(16, imprevisti.size());
		assertEquals("Andate sino al Largo Colombo: se passate dal Via ritirate 500€.",
				imprevisti.get(0));

	}

	@Test
	void test_probabilita() {

		Tabellone tabellone = monopoly.getTabellone();

		List<String> probabilità = tabellone.getProbabilità();
		assertEquals(16, probabilità.size());
		assertEquals("Ritornate al Vicolo Corto.", probabilità.get(0));
	}

	@Test
	void test_casette() {

		Tabellone tabellone = monopoly.getTabellone();

		List<Casa> casette = tabellone.getCase();
		assertEquals(32, casette.size());
	}

	@Test
	void test_alberghi() {

		Tabellone tabellone = monopoly.getTabellone();

		List<Albergo> alberghi = tabellone.getAlberghi();
		assertEquals(12, alberghi.size());
	}

	@Test
	void test_dadi() {

		List<Dado> dadi = monopoly.getDadi();
		assertEquals(2, dadi.size());
		assertEquals(6, dadi.get(0).getNumeroFacce());
	}

	@Test
	void test() {

		assertNotNull(monopoly.getGiocatore().getSegnalino());

		assertTrue(monopoly.getGiocatore().lanciaDadi() >= 1);
		assertTrue(monopoly.getGiocatore().lanciaDadi() <= 6);

		assertEquals(8, monopoly.getGiocatore().setNuovaPosizione(3, 5));

		int posizione = monopoly.getGiocatore().getPosizione();
		int risultatoDado = monopoly.getGiocatore().lanciaDadi();
		assertTrue(monopoly.getGiocatore().setNuovaPosizione(posizione, risultatoDado) <= 40);

		Giocatore giocatore1 = new Giocatore("Saverio", Segnalini.CANE);
		assertEquals(1500, giocatore1.getPortafoglio());
		giocatore1.setNuovaPosizione(39, 6);
		assertEquals(1700, giocatore1.getPortafoglio());

		Giocatore giocatore2 = new Giocatore("Alberto", Segnalini.DINOSAURO);
		giocatore2.setNuovaPosizione(giocatore2.getPosizione(), 1);

		// Casella casella1 = new Casella("Vicolo Corto", true, "fucsia");
		// giocatore1.acquistaCasella(casella1);
		// assertEquals(1, giocatore1.getCasellePosseduteDaTuttiIGiocatori().size());
		// assertFalse(giocatore1.casellaAcquistabile(casella1, contratti.get(1)));

		/*
		 * String nome1 = "Antonio";
		 * String nome2 = "Alessio";
		 * Giocatore giocatore1 = new Giocatore(nome1, Segnalini.CANE);
		 * Giocatore giocatore2 = new Giocatore(nome2, Segnalini.DINOSAURO);
		 * assertNotNull(giocatore1);
		 * assertNotNull(giocatore2);
		 * 
		 * assertEquals("Antonio", giocatore1.getNome());
		 * assertEquals(Segnalini.CANE, giocatore1.getSegnalino());
		 * assertEquals(0, giocatore1.getPosizione());
		 * assertEquals("Alessio", giocatore2.getNome());
		 * assertEquals(Segnalini.DINOSAURO, giocatore2.getSegnalino());
		 * assertEquals(0, giocatore2.getPosizione());
		 */

		// assertTrue((giocatore1.lanciaDadi()) <= (numeroDadi * numeroFacce));
	}
}
