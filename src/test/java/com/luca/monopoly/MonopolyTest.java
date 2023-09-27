package com.luca.monopoly;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MonopolyTest {
	@Test
	void test() {
		Monopoly monopoly = new Monopoly();

		assertNotNull(monopoly);

		assertEquals(40, monopoly.getTabellone().getCaselle().size());

		assertEquals("Via", monopoly.getTabellone().getCaselle().get(0).getTesto());
		assertFalse(monopoly.getTabellone().getCaselle().get(0).isTerreno());
		assertEquals(null, monopoly.getTabellone().getCaselle().get(0).getColore());
		assertEquals("Vicolo Corto", monopoly.getTabellone().getCaselle().get(1).getTesto());
		assertTrue(monopoly.getTabellone().getCaselle().get(1).isTerreno());
		assertEquals("fucsia", monopoly.getTabellone().getCaselle().get(1).getColore());

		assertEquals(8, monopoly.getSegnalini().size());
		assertEquals("Cane", Segnalini.CANE.getNome());

		assertEquals(28, monopoly.getTabellone().getContratti().size());
		assertEquals("Vicolo Corto", monopoly.getTabellone().getContratti().get(0).getTesto());
		assertEquals(10, monopoly.getTabellone().getContratti().get(1).getRenditaTerreno());
		assertEquals(500, monopoly.getTabellone().getContratti().get(27).getRenditaUnaCasa());
		assertEquals(1000, monopoly.getTabellone().getContratti().get(13).getRenditaAlbergo());
		assertEquals(65, monopoly.getTabellone().getContratti().get(2).getRenditaUnaStazione());
		assertEquals(130, monopoly.getTabellone().getContratti().get(2).getRenditaDueStazioni());

		assertEquals(16, monopoly.getTabellone().getImprevisti().size());
		assertEquals("Andate sino al Largo Colombo: se passate dal Via ritirate 500€.",
				monopoly.getTabellone().getImprevisti().get(0));

		assertEquals(16, monopoly.getTabellone().getProbabilità().size());
		assertEquals("Ritornate al Vicolo Corto.", monopoly.getTabellone().getProbabilità().get(0));

		assertEquals(32, monopoly.getTabellone().getCase().size());
		assertEquals(12, monopoly.getTabellone().getAlberghi().size());

		int numeroDadi = monopoly.getDadi().getNumeroDadi();
		assertEquals(2, numeroDadi);
		int numeroFacce = monopoly.getDadi().getNumeroFacce();
		assertEquals(6, numeroFacce);

		String nome1 = "Antonio";
		String nome2 = "Alessio";
		Giocatore giocatore1 = new Giocatore(nome1, Segnalini.CANE);
		Giocatore giocatore2 = new Giocatore(nome2, Segnalini.DINOSAURO);
		assertNotNull(giocatore1);
		assertNotNull(giocatore2);

		assertEquals("Antonio", giocatore1.getNome());
		assertEquals(Segnalini.CANE, giocatore1.getSegnalino());
		assertEquals(0, giocatore1.getPosizione());
		assertEquals("Alessio", giocatore2.getNome());
		assertEquals(Segnalini.DINOSAURO, giocatore2.getSegnalino());
		assertEquals(0, giocatore2.getPosizione());

		assertTrue((giocatore1.lanciaDadi()) <= (numeroDadi * numeroFacce));
	}
}