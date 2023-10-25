package com.luca.monopoly;

public class Casella {
	private String testo;
	private boolean terreno;
	private String colore;


	private int costoProprieta;

	public Casella(String testo, boolean terreno, String colore, int costoProprieta) {
		this.testo = testo;
		this.terreno = terreno;
		this.colore = colore;
		this.costoProprieta = costoProprieta;
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

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public void setTerreno(boolean terreno) {
		this.terreno = terreno;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public int getCostoProprieta() {
		return costoProprieta;
	}

	public void setCostoProprieta(int costoProprieta) {
		this.costoProprieta = costoProprieta;
	}

}
