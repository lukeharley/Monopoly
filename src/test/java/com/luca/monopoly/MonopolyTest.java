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
	private Partita partita;

	@BeforeEach
	void setup() {
		monopoly = new Monopoly();

		giocatori = monopoly.getGiocatori();
		partita = new Partita();

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

		assertEquals(40, contratti.size());

		assertEquals("Vicolo Corto", contratti.get(1).getTesto());
		assertEquals(4, contratti.get(3).getRenditaTerreno());
		assertEquals(175, contratti.get(37).getRenditaUnaCasetta());
		assertEquals(400, contratti.get(19).getRenditaAlbergo());
		assertEquals(65, contratti.get(35).getRenditaUnaStazione());
		assertEquals(130, contratti.get(35).getRenditaDueStazioni());

	}

	@Order(5)

	@Test
	void test_imprevisti() {

		Tabellone tabellone = monopoly.getTabellone();

		Giocatore giocatore1 = giocatori.get(0);
		assertEquals(0, giocatore1.getPosizione());
		assertEquals(1500, giocatore1.getPortafoglio());

		List<Casella> caselle = monopoly.getTabellone().getCaselle();
		List<Imprevisto> mazzoCartePescateImprevisti = giocatore1.getMazzoCartePescateImprevisti();

		List<Imprevisto> imprevisti = tabellone.getImprevisti();
		assertEquals(16, imprevisti.size());
		Imprevisto primaCartaImprevisto = imprevisti.get(0);
		assertEquals("Andate sino al Largo Colombo: se passate dal Via ritirate 500 euro.",
				primaCartaImprevisto.getTesto());

		giocatore1.aggiornaPosizione(7);
		giocatore1.aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);
		assertEquals(1500, giocatore1.getPortafoglio());

		giocatore1.aggiornaPosizione(15);
		giocatore1.aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);
		assertEquals(1500, giocatore1.getPortafoglio());

		giocatore1.aggiornaPosizione(2);
		giocatore1.aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);
		giocatore1.aggiornaPosizione(2);
		giocatore1.aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);
		giocatore1.aggiornaPosizione(2);
		giocatore1.aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);
		giocatore1.aggiornaPosizione(2);
		giocatore1.aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);
		giocatore1.aggiornaPosizione(2);
		giocatore1.aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);
		giocatore1.aggiornaPosizione(2);
		giocatore1.aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);
		giocatore1.aggiornaPosizione(2);
		giocatore1.aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);
		giocatore1.aggiornaPosizione(2);
		giocatore1.aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);
		giocatore1.aggiornaPosizione(2);
		giocatore1.aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);
		giocatore1.aggiornaPosizione(2);
		giocatore1.aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);
		giocatore1.aggiornaPosizione(2);
		giocatore1.aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);
		giocatore1.aggiornaPosizione(2);
		giocatore1.aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);
		giocatore1.aggiornaPosizione(2);
		giocatore1.aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);
		giocatore1.aggiornaPosizione(2);
		giocatore1.aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);
		giocatore1.aggiornaPosizione(2);
		giocatore1.aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);
		giocatore1.aggiornaPosizione(2);
		giocatore1.aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);
		giocatore1.aggiornaPosizione(2);
		giocatore1.aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);
		giocatore1.aggiornaPosizione(2);
		giocatore1.aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);
		giocatore1.aggiornaPosizione(2);
		giocatore1.aggiornaPosizioneEPortafoglioSeImprevisto(caselle, imprevisti, mazzoCartePescateImprevisti);

		// aggiungere assertEquals ad ogni step per verificare andamento portafoglio

	}

	@Order(6)

	@Test
	void test_probabilita() {

		Tabellone tabellone = monopoly.getTabellone();

		Giocatore giocatore1 = giocatori.get(0);
		assertEquals(0, giocatore1.getPosizione());
		assertEquals(1500, giocatore1.getPortafoglio());

		List<Casella> caselle = monopoly.getTabellone().getCaselle();
		List<Probabilita> mazzoCartePescateProbabilita = giocatore1.getMazzoCartePescateProbabilita();

		List<Probabilita> probabilita = tabellone.getProbabilita();
		assertEquals(16, probabilita.size());

		Probabilita primaCartaProbabilita = probabilita.get(0);
		assertEquals("Ritornate al Vicolo Corto.", primaCartaProbabilita.getTesto());

		giocatore1.aggiornaPosizione(2);
		giocatore1.aggiornaPosizioneEPortafoglioSeProbabilita(caselle, probabilita, mazzoCartePescateProbabilita);
		assertEquals(1500, giocatore1.getPortafoglio());
		/*
		 * Nel metodo successivo sposto il segnalino di una posizione per raggiungere la
		 * prossima carta Probabilità in quanto con la prima probabilità il giocatore è
		 * tornato alla casella Vicolo Corto
		 */
		giocatore1.aggiornaPosizione(1);
		giocatore1.aggiornaPosizioneEPortafoglioSeProbabilita(caselle, probabilita, mazzoCartePescateProbabilita);
		assertEquals(1560, giocatore1.getPortafoglio());

		// rimane da testare esaurimento del mazzo di carte
	}

	@Order(7)
	@Test
	void test_casette() {

		Tabellone tabellone = monopoly.getTabellone();

		List<Casetta> casette = tabellone.getCasette();
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

		giocatore1.aggiornaPosizione(12);
		assertEquals(12, giocatore1.getPosizione());
		assertEquals(1500, giocatore1.getPortafoglio());

		giocatore1.aggiornaPosizione(12);
		assertEquals(24, giocatore1.getPosizione());
		assertEquals(1500, giocatore1.getPortafoglio());

		giocatore1.aggiornaPosizione(12);
		assertEquals(36, giocatore1.getPosizione());
		assertEquals(1500, giocatore1.getPortafoglio());

		giocatore1.aggiornaPosizioneSePassaDalVia(12);
		assertEquals(8, giocatore1.getPosizione());
		assertEquals(1700, giocatore1.getPortafoglio());

		giocatore1.aggiornaPosizione(12);
		assertEquals(20, giocatore1.getPosizione());
		assertEquals(1700, giocatore1.getPortafoglio());

	}

	@Order(11)
	@Test
	void test_giocatore_proprieta_e_affitto_terreno_o_casetta() {

		Giocatore giocatore1 = giocatori.get(0);
		Giocatore giocatore2 = giocatori.get(1);

		Map<String, Giocatore> proprietariDeiContratti = monopoly.getTabellone().getProprietariDeiContratti();
		assertEquals(28, proprietariDeiContratti.size());

		List<Casella> caselle = monopoly.getTabellone().getCaselle();
		List<Contratto> contratti = monopoly.getTabellone().getContratti();

		giocatore1.aggiornaPosizione(3);
		giocatore1.compraProprieta(proprietariDeiContratti, caselle);
		assertEquals(giocatore1, proprietariDeiContratti.get("Vicolo Stretto"));
		assertEquals(1440, giocatore1.getPortafoglio());

		giocatore2.aggiornaPosizione(3);
		giocatore2.aggiornaPortafoglioSeAffitto(caselle, contratti, proprietariDeiContratti, giocatore2);
		assertEquals(1496, giocatore2.getPortafoglio());

	}

	@Order(12)
	@Test
	void test_costruzione_casetta() {

		Giocatore giocatoreCorrente = giocatori.get(0);
		System.out.println(giocatoreCorrente.toString());

		Map<String, Giocatore> proprietariDeiContratti = monopoly.getTabellone().getProprietariDeiContratti();
		List<Casella> caselle = monopoly.getTabellone().getCaselle();

		proprietariDeiContratti.put("Bastioni Gran Sasso", giocatoreCorrente);
		proprietariDeiContratti.put("Viale Monterosa", giocatoreCorrente);
		proprietariDeiContratti.put("Viale Vesuvio", giocatoreCorrente);

		giocatoreCorrente.setPosizione(6);
		assertEquals(1, giocatoreCorrente.costruisciCasette(proprietariDeiContratti, caselle));
		giocatoreCorrente.setPosizione(6);
		assertEquals(2, giocatoreCorrente.costruisciCasette(proprietariDeiContratti, caselle));
		giocatoreCorrente.setPosizione(6);
		assertEquals(3, giocatoreCorrente.costruisciCasette(proprietariDeiContratti, caselle));
		giocatoreCorrente.setPosizione(6);
		assertEquals(4, giocatoreCorrente.costruisciCasette(proprietariDeiContratti, caselle));
		giocatoreCorrente.setPosizione(6);
		assertEquals(5, giocatoreCorrente.costruisciCasette(proprietariDeiContratti, caselle));
		giocatoreCorrente.setPosizione(6);
		assertEquals(5, giocatoreCorrente.costruisciCasette(proprietariDeiContratti, caselle));

	}

	@Order(13)
	@Test
	void test_giocatore_pagamento_tasse() {

		Giocatore giocatoreCorrente = giocatori.get(0);
		List<Casella> caselle = monopoly.getTabellone().getCaselle();
		List<Contratto> contratti = monopoly.getTabellone().getContratti();
		Map<String, Giocatore> proprietariDeiContratti = monopoly.getTabellone().getProprietariDeiContratti();

		giocatoreCorrente.aggiornaPosizione(4);
		giocatoreCorrente.aggiornaPortafoglioSeTasse(proprietariDeiContratti, giocatoreCorrente, caselle, contratti);
		assertEquals(1300, giocatoreCorrente.getPortafoglio());

	}

	@Order(14)
	@Test
	void test_giocatore_in_prigione() {

		Giocatore giocatore1 = giocatori.get(0);
		giocatore1.aggiornaPosizione(12);
		giocatore1.aggiornaPosizione(12);
		giocatore1.aggiornaPosizione(6);
		giocatore1.aggiornaPosizioneSeInPrigione();
		assertEquals(10, giocatore1.getPosizione());

	}

	@Order(15)
	@Test
	void test_partita() {
		assertNotNull(partita);
	}

}
