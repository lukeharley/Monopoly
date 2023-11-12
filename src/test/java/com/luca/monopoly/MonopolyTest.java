package com.luca.monopoly;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MonopolyTest {

	private Monopoly monopoly;
	private List<Giocatore> giocatori;

	@BeforeEach
	void setup() {
		monopoly = new Monopoly();

		giocatori = new ArrayList<>();
		giocatori.add(monopoly.getGiocatore());
		giocatori.add(monopoly.getGiocatore());

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

		Giocatore giocatore1 = giocatori.get(0);

		assertNotNull(giocatore1.getSegnalino());

		assertEquals(0, giocatore1.getPosizione());
		assertEquals(1500, giocatore1.getPortafoglio());

		assertTrue(giocatore1.lanciaDadi() >= 2);
		assertTrue(giocatore1.lanciaDadi() <= 12);

		List<Contratto> contratti = monopoly.getTabellone().getContratti();
		Map<String, Giocatore> proprietariDeiContratti = monopoly.getTabellone().getProprietariDeiContratti();
		Map<String, Integer> numeroDiCasetteSullaCasella = monopoly.getTabellone().getNumeroDiCasetteSullaCasella();

		// TODO: il nome della proprietà si può estrarre in base al risultato del dado
		Contratto contrattoTarget1 = contratti.stream()
				.filter(contratto -> contratto.getTesto().equals("Via Accademia")).findFirst().orElse(null);
		giocatore1.aggiornaPosizioneEPortafoglio(12, proprietariDeiContratti, "Via Accademia", contrattoTarget1,
				numeroDiCasetteSullaCasella);
		assertEquals(12, giocatore1.getPosizione());
		assertEquals(1500, giocatore1.getPortafoglio());

		Contratto contrattoTarget2 = contratti.stream()
				.filter(contratto -> contratto.getTesto().equals("Corso Magellano")).findFirst().orElse(null);
		giocatore1.aggiornaPosizioneEPortafoglio(12, proprietariDeiContratti, "Corso Magellano", contrattoTarget2,
				numeroDiCasetteSullaCasella);
		assertEquals(24, giocatore1.getPosizione());
		assertEquals(1500, giocatore1.getPortafoglio());

		Contratto contrattoTarget3 = contratti.stream()
				.filter(contratto -> contratto.getTesto().equals("Stazione Est")).findFirst().orElse(null);
		giocatore1.aggiornaPosizioneEPortafoglio(12, proprietariDeiContratti, "Stazione Est", contrattoTarget3,
				numeroDiCasetteSullaCasella);
		assertEquals(36, giocatore1.getPosizione());
		assertEquals(1500, giocatore1.getPortafoglio());

		Contratto contrattoTarget4 = contratti.stream()
				.filter(contratto -> contratto.getTesto().equals("Imprevisti")).findFirst().orElse(null);
		giocatore1.aggiornaPosizioneEPortafoglio(12, proprietariDeiContratti, "Imprevisti", contrattoTarget4,
				numeroDiCasetteSullaCasella);
		assertEquals(8, giocatore1.getPosizione());
		assertEquals(2000, giocatore1.getPortafoglio());

		Contratto contrattoTarget5 = contratti.stream()
				.filter(contratto -> contratto.getTesto().equals("Piazza Dante")).findFirst().orElse(null);
		giocatore1.aggiornaPosizioneEPortafoglio(12, proprietariDeiContratti, "Piazza Dante", contrattoTarget5,
				numeroDiCasetteSullaCasella);
		assertEquals(20, giocatore1.getPosizione());
		assertEquals(2000, giocatore1.getPortafoglio());

	}

	@Order(11)
	@Test
	void test_giocatore_proprieta_e_affitto_terreno() {

		List<Casella> caselle = monopoly.getTabellone().getCaselle();
		Giocatore giocatore1 = giocatori.get(0);
		Giocatore giocatore2 = giocatori.get(1);
		List<Contratto> contratti = monopoly.getTabellone().getContratti();

		Map<String, Giocatore> proprietariDeiContratti = monopoly.getTabellone().getProprietariDeiContratti();
		assertEquals(28, proprietariDeiContratti.size());
		Map<String, Integer> numeroDiCasetteSullaCasella = monopoly.getTabellone().getNumeroDiCasetteSullaCasella();

		giocatore1.compraProprieta(proprietariDeiContratti, "Vicolo Stretto", caselle);
		assertEquals(giocatore1, proprietariDeiContratti.get("Vicolo Stretto"));
		assertEquals(1350, giocatore1.getPortafoglio());

		Contratto contrattoTarget = contratti.stream()
				.filter(contratto -> contratto.getTesto().equals("Vicolo Stretto")).findFirst().orElse(null);

		giocatore2.aggiornaPosizioneEPortafoglio(3, proprietariDeiContratti, "Vicolo Stretto", contrattoTarget,
				numeroDiCasetteSullaCasella);
		assertEquals(1490, giocatore2.getPortafoglio());

	}

}
