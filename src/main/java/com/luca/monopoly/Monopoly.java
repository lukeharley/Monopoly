package com.luca.monopoly;

import java.util.Arrays;
import java.util.List;

public class Monopoly {
	public Tabellone getTabellone() {
		return new Tabellone();
	}

    public List<Segnalini> getSegnalini() {
        return Arrays.asList(Segnalini.values());
    }

	public Casa getCase() {

		Casa casa = new Casa(false); 		

		return casa; 
	}

	public Casa getAlberghi() {

		Casa albergo = new Casa(true); 

		return albergo; 

	}

	public Dado getDadi() {
		return new Dado(); 
	}
} 
