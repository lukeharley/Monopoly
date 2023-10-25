package com.luca.monopoly;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MonopolyTest {

	private Monopoly monopoly = new Monopoly();

	@BeforeEach
	void setup() {
		monopoly = new Monopoly();
	}

	@Order(1)
	@Test
	void test_inizializzazione_monopoly() {

		assertNotNull(monopoly);

	}

	@Order(2)
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

	@Order(3)
	@Test
	void test_segnalini() {

		List<Segnalini> segnalini = monopoly.getSegnalini();
		assertEquals(8, segnalini.size());

	}

	@Order(4)
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

	@Order(5)
	@Test
	void test_imprevisti() {

		Tabellone tabellone = monopoly.getTabellone();

		List<String> imprevisti = tabellone.getImprevisti();
		assertEquals(16, imprevisti.size());

		String primaCartaImprevisto = imprevisti.get(0);
		assertEquals("Andate sino al Largo Colombo: se passate dal Via ritirate 500€.",
				primaCartaImprevisto);

	}

	@Order(6)
	@Test
	void test_probabilita() {

		Tabellone tabellone = monopoly.getTabellone();

		List<String> probabilita = tabellone.getProbabilità();
		assertEquals(16, probabilita.size());

		String primaCartaProbabilita = probabilita.get(0);
		assertEquals("Ritornate al Vicolo Corto.", primaCartaProbabilita);
	}

	@Order(7)
	@Test
	void test_casette() {

		Tabellone tabellone = monopoly.getTabellone();

		List<Casa> casette = tabellone.getCase();
		assertEquals(32, casette.size());
	}

	@Order(8)
	@Test
	void test_alberghi() {

		Tabellone tabellone = monopoly.getTabellone();

		List<Albergo> alberghi = tabellone.getAlberghi();
		assertEquals(12, alberghi.size());
	}

	@Order(9)
	@Test
	void test_dadi() {

		List<Dado> dadi = monopoly.getDadi();
		assertEquals(2, dadi.size());

		Dado primoDado = dadi.get(0);
		assertEquals(6, primoDado.getNumeroFacce());
	}

	@Order(10)
	@Test
	void test_giocatore() {

		Giocatore giocatore = monopoly.getGiocatore();

		assertNotNull(giocatore.getSegnalino());

		assertTrue(giocatore.lanciaDadi() >= 1);
		assertTrue(giocatore.lanciaDadi() <= 6);

		assertEquals(8, giocatore.setNuovaPosizione(3, 5));

	}
}
