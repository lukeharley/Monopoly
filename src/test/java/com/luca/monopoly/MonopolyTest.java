package com.luca.monopoly;

import com.luca.monopoly.domain.*;
import org.junit.jupiter.api.*;

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

		giocatori = monopoly.getGiocatori();

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

		Giocatore giocatore1 = giocatori.get(0);
		assertEquals(0, giocatore1.getPosizione());
		assertEquals(1500, giocatore1.getPortafoglio());

		List<Casella> caselle = monopoly.getTabellone().getCaselle();
		List<Contratto> contratti = monopoly.getTabellone().getContratti();
		Map<String, Giocatore> proprietariDeiContratti = monopoly.getTabellone().getProprietariDeiContratti();
		List<Probabilita> probabilita = monopoly.getTabellone().getProbabilita();

		List<Imprevisto> imprevisti = tabellone.getImprevisti();
		assertEquals(16, imprevisti.size());

		Imprevisto primaCartaImprevisto = imprevisti.get(0);
		assertEquals("Andate sino al Largo Colombo: se passate dal Via ritirate 500€.",
				primaCartaImprevisto.getTesto());

		giocatore1.aggiornaPosizioneEPortafoglio(7, proprietariDeiContratti, caselle, contratti, imprevisti,
				probabilita);
		assertEquals(1500, giocatore1.getPortafoglio());
		giocatore1.aggiornaPosizioneEPortafoglio(15, proprietariDeiContratti, caselle, contratti, imprevisti,
				probabilita);
		assertEquals(1500, giocatore1.getPortafoglio());

		// rimane da testare esaurimento del mazzo di carte

	}

	@Order(6)
	@Test
	void test_probabilita() {

		Tabellone tabellone = monopoly.getTabellone();

		Giocatore giocatore1 = giocatori.get(0);
		assertEquals(0, giocatore1.getPosizione());
		assertEquals(1500, giocatore1.getPortafoglio());

		List<Casella> caselle = monopoly.getTabellone().getCaselle();
		List<Contratto> contratti = monopoly.getTabellone().getContratti();
		Map<String, Giocatore> proprietariDeiContratti = monopoly.getTabellone().getProprietariDeiContratti();
		List<Imprevisto> imprevisti = monopoly.getTabellone().getImprevisti();

		List<Probabilita> probabilita = tabellone.getProbabilita();
		assertEquals(16, probabilita.size());

		Probabilita primaCartaProbabilita = probabilita.get(0);
		assertEquals("Ritornate al Vicolo Corto.", primaCartaProbabilita.getTesto());

		giocatore1.aggiornaPosizioneEPortafoglio(2, proprietariDeiContratti, caselle, contratti, imprevisti,
				probabilita);
		assertEquals(1500, giocatore1.getPortafoglio());
		// Nel metodo successivo sposto il segnalino di una posizione per raggiungere la
		// prossima carta
		// Probabilità in quanto con la prima probabilità il giocatore è tornato alla
		// casella Vicolo Corto
		giocatore1.aggiornaPosizioneEPortafoglio(1, proprietariDeiContratti, caselle, contratti, imprevisti,
				probabilita);
		assertEquals(1560, giocatore1.getPortafoglio());

		// rimane da testare esaurimento del mazzo di carte
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

		Map<String, Giocatore> proprietariDeiContratti = monopoly.getTabellone().getProprietariDeiContratti();
		List<Casella> caselle = monopoly.getTabellone().getCaselle();
		List<Contratto> contratti = monopoly.getTabellone().getContratti();
		List<Imprevisto> imprevisti = monopoly.getTabellone().getImprevisti();
		List<Probabilita> probabilita = monopoly.getTabellone().getProbabilita();

		giocatore1.aggiornaPosizioneEPortafoglio(12, proprietariDeiContratti, caselle, contratti, imprevisti,
				probabilita);
		assertEquals(12, giocatore1.getPosizione());
		assertEquals(1500, giocatore1.getPortafoglio());

		giocatore1.aggiornaPosizioneEPortafoglio(12, proprietariDeiContratti, caselle, contratti, imprevisti,
				probabilita);
		assertEquals(24, giocatore1.getPosizione());
		assertEquals(1500, giocatore1.getPortafoglio());

		giocatore1.aggiornaPosizioneEPortafoglio(12, proprietariDeiContratti, caselle, contratti, imprevisti,
				probabilita);

		assertEquals(36, giocatore1.getPosizione());
		assertEquals(2000, giocatore1.getPortafoglio()); // sono stati aggiunti anche 500€ degli imprevisti

		giocatore1.aggiornaPosizioneEPortafoglio(12, proprietariDeiContratti, caselle, contratti, imprevisti,
				probabilita);
		assertEquals(8, giocatore1.getPosizione());
		assertEquals(2500, giocatore1.getPortafoglio()); // sono stati aggiunti anche 500€ degli imprevisti

		giocatore1.aggiornaPosizioneEPortafoglio(12, proprietariDeiContratti, caselle, contratti, imprevisti,
				probabilita);
		assertEquals(20, giocatore1.getPosizione());
		assertEquals(2500, giocatore1.getPortafoglio());

	}

	@Order(11)
	@Test
	void test_giocatore_proprieta_e_affitto_terreno_o_casa() {

		Giocatore giocatore1 = giocatori.get(0);
		Giocatore giocatore2 = giocatori.get(1);

		Map<String, Giocatore> proprietariDeiContratti = monopoly.getTabellone().getProprietariDeiContratti();
		assertEquals(28, proprietariDeiContratti.size());
		List<Casella> caselle = monopoly.getTabellone().getCaselle();
		List<Contratto> contratti = monopoly.getTabellone().getContratti();
		List<Imprevisto> imprevisti = monopoly.getTabellone().getImprevisti();
		List<Probabilita> probabilita = monopoly.getTabellone().getProbabilita();

		giocatore1.compraProprieta(proprietariDeiContratti, "Vicolo Stretto", caselle);
		assertEquals(giocatore1, proprietariDeiContratti.get("Vicolo Stretto"));
		assertEquals(1350, giocatore1.getPortafoglio());

		giocatore2.aggiornaPosizioneEPortafoglio(3, proprietariDeiContratti, caselle, contratti, imprevisti,
				probabilita);
		assertEquals(1490, giocatore2.getPortafoglio());

	}

	@Order(12)
	@Test
	void test_giocatore_pagamento_tasse() {

		Giocatore giocatore1 = giocatori.get(0);
		Map<String, Giocatore> proprietariDeiContratti = monopoly.getTabellone().getProprietariDeiContratti();
		List<Casella> caselle = monopoly.getTabellone().getCaselle();
		List<Contratto> contratti = monopoly.getTabellone().getContratti();
		List<Imprevisto> imprevisti = monopoly.getTabellone().getImprevisti();
		List<Probabilita> probabilita = monopoly.getTabellone().getProbabilita();

		giocatore1.aggiornaPosizioneEPortafoglio(4, proprietariDeiContratti, caselle, contratti, imprevisti,
				probabilita);
		assertEquals(1460, giocatore1.getPortafoglio());

	}

}
