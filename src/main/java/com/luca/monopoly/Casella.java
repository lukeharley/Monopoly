package com.luca.monopoly;

public class Casella {
	private String testo;
	private boolean terreno;
	private String colore;

	public Casella(String testo, boolean terreno, String colore) {
		this.testo = testo;
		this.terreno = terreno;
		this.colore = colore;
	}

	public String getTesto() {
		return testo;
	}

	public boolean isTerreno() {
		return terreno;
	}

	public String getColore() {
		return colore;
	}
}