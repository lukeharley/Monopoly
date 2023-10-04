package com.luca.monopoly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Monopoly {

	public Tabellone getTabellone() {
		return new Tabellone();
	}

	public List<Segnalini> getSegnalini() {
		return Arrays.asList(Segnalini.values());
	}

	public List<Dado> getDadi() {

		List<Dado> dadi = new ArrayList<>();

		for(int i = 1; i <= 2; i++) {
			dadi.add(new Dado());
		}

		return dadi;
	}

	public Giocatore getGiocatore() {
		return new Giocatore(Segnalini.CANE);
	}
}
