package com.luca.monopoly;

public class Contratto {
    private String nome; 
    private int renditaTerreno; 
    private int renditaUnaCasa; 

    /* private int renditaStazione; 
    private int renditaDueStazioni; - *2*/
    

    public Contratto(String nome, int renditaTerreno, int renditaUnaCasa) {
        this.nome = nome; 
        this.renditaTerreno = renditaTerreno; 
        this.renditaUnaCasa = renditaUnaCasa; 

    }

    public String getNome() {
		return nome;
	}

    public int getRenditaTerreno() {
		return renditaTerreno;
	}

    public int getRenditaUnaCasa() {
		return renditaUnaCasa;
	}


}
