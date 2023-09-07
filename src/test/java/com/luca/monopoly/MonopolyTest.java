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
		assertEquals("Vicolo Corto", monopoly.getTabellone().getContratti().get(0).getNome());
		assertEquals(10, monopoly.getTabellone().getContratti().get(1).getRenditaTerreno());
		assertEquals(500, monopoly.getTabellone().getContratti().get(27).getRenditaUnaCasa());
		assertEquals(1000, monopoly.getTabellone().getContratti().get(13).getRenditaAlbergo()); 
		assertEquals(65, monopoly.getTabellone().getContratti().get(2).getRenditaUnaStazione());
		assertEquals(130, monopoly.getTabellone().getContratti().get(2).getRenditaDueStazioni());

		assertEquals(16, monopoly.getTabellone().getImprevisti().size());
        assertEquals("Andate sino al Largo Colombo: se passate dal Via ritirate 500€.", monopoly.getTabellone().getImprevisti().get(0));

		assertEquals(16, monopoly.getTabellone().getProbabilità().size());
		assertEquals("Ritornate al Vicolo Corto.", monopoly.getTabellone().getProbabilità().get(0));

		assertEquals(32, monopoly.getTabellone().getCase().getNumeroCase());
		assertEquals(12, monopoly.getTabellone().getCase().getNumeroAlberghi());
		
		assertEquals(2, monopoly.getDadi());


	}
}