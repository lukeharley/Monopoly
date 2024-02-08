package com.luca.monopoly.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Monopoly {

	private final Tabellone tabellone;
	private final Banca banca;

	public Monopoly() {
		this.tabellone = new Tabellone();
		this.banca = new Banca();
	}

	public Tabellone getTabellone() {
		return tabellone;
	}

	public Banca getBanca() {
		return banca;
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
		int patrimonio = banca.getPatrimonio(); 

		giocatori.add(new Giocatore(Segnalini.CANE, 1500, 0));
		giocatori.add(new Giocatore(Segnalini.DINOSAURO, 1500, 0));
		patrimonio -= giocatori.get(0).getPortafoglio(); 
		patrimonio -= giocatori.get(1).getPortafoglio();
		System.out.println("Il patrimonio della banca è pari a " + patrimonio); 
 
		return giocatori;
	}
}
