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

	//public Casa getCase() {
	//	return new Casa();
//	}

	public int getDadi() {
		return 2;
	}
} 
