package com.luca.monopoly;

public class Monopoly {
	public Tabellone getTabellone() {
		return new Tabellone();
	}
	
	public int getSegnalini() {
		return Segnalini.values().length;
	}

	public Segnalini getSegnaliniNome(Segnalini segnalino) {
		return segnalino;
	}

	public int getContratti() {
		return 28;
	}

	public int getCase() {
		return 32;
	}

	public int getAlberghi() {
		return 12;
	}

	public int getDadi() {
		return 2;
	}
} 
