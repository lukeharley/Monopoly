package com.luca.monopoly.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Monopoly {

	private final Tabellone tabellone;

	public Monopoly() {
		this.tabellone = new Tabellone();
	}

	public Tabellone getTabellone() {
		return tabellone;
	}

	public List<Segnalini> getSegnalini() {
		return Arrays.asList(Segnalini.values());
	}

	public List<Dado> getDadi() {

		List<Dado> dadi = new ArrayList<>();

		for (int i = 1; i <= 2; i++) {
			dadi.add(new Dado());
		}

		return dadi;
	}

	public List<Giocatore> getGiocatori() {

		List<Giocatore> giocatori = new ArrayList<>();

		giocatori.add(new Giocatore(Segnalini.CANE, 1500, 0));
		giocatori.add(new Giocatore(Segnalini.DINOSAURO, 1500, 0));

		return giocatori;
	}
}
