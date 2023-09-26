package com.luca.monopoly;

import java.util.Arrays;
import java.util.List;

public class Monopoly {

	private int numeroCase = 32;
    private int numeroAlberghi = 12; 

	public Tabellone getTabellone() {
		return new Tabellone();
	}

    public List<Segnalini> getSegnalini() {
        return Arrays.asList(Segnalini.values());
    }

	public int getNumeroCase() {
		return numeroCase; 
	}

	public int getNumeroAlberghi() {
		return numeroAlberghi; 
	}

	public Dado getDadi() {
		return new Dado(); 
	}
} 
