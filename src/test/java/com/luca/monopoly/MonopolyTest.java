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
	void test_giocatore_posizione() {

		Giocatore giocatore = monopoly.getGiocatore();

		assertNotNull(giocatore.getSegnalino());

		assertEquals(0, giocatore.getPosizione());
		assertEquals(1500, giocatore.getPortafoglio());

		assertTrue(giocatore.lanciaDadi() >= 2);
		assertTrue(giocatore.lanciaDadi() <= 12);

		List<Contratto> contratti = monopoly.getTabellone().getContratti();
		List<Casella> caselle = monopoly.getTabellone().getCaselle();
		// TODO Luca: Riverificare questi test
		giocatore.aggiornaPosizioneEPortafoglio(12, contratti, caselle);
		assertEquals(12, giocatore.getPosizione());
		assertEquals(1500, giocatore.getPortafoglio());

		giocatore.aggiornaPosizioneEPortafoglio(12, contratti, caselle);
		assertEquals(24, giocatore.getPosizione());
		assertEquals(1450, giocatore.getPortafoglio());

		giocatore.aggiornaPosizioneEPortafoglio(12, contratti, caselle);
		assertEquals(36, giocatore.getPosizione());
		assertEquals(1450, giocatore.getPortafoglio());

		giocatore.aggiornaPosizioneEPortafoglio(12, contratti, caselle);
		assertEquals(8, giocatore.getPosizione());
		assertEquals(1935, giocatore.getPortafoglio());

	}

	@Order(11)
	@Test
	void test_giocatore_proprieta_e_affitto() {

		Giocatore giocatore1 = monopoly.getGiocatore();
		List<Contratto> contratti = monopoly.getTabellone().getContratti();
		List<Casella> caselle = monopoly.getTabellone().getCaselle();

		giocatore1.aggiornaPosizioneEPortafoglio(3, contratti, caselle);

		giocatore1.compraProprieta(contratti, caselle, "Vicolo Stretto");
		assertEquals(1340, giocatore1.getPortafoglio());
		assertEquals("Vicolo Stretto", giocatore1.getContratti().get(0).getTesto());
		assertEquals(27, monopoly.getTabellone().getContratti().size());

		Giocatore giocatore2 = monopoly.getGiocatore();
		giocatore2.aggiornaPosizioneEPortafoglio(3, contratti, caselle);
		assertEquals(1500, giocatore2.getPortafoglio());

	}

}
