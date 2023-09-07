package com.luca.monopoly;

public class Contratto {
    private String nome; 
    private int renditaTerreno; 
    private int renditaUnaCasa; 
    private int renditaDueCase; 
    private int renditaTreCase; 
    private int renditaQuattroCase; 
    private int renditaAlbergo; 
    private int renditaUnaStazione; 
    private int renditaDueStazioni;
    private int renditaTreStazioni;
    private int renditaQuattroStazioni; 
    

    public Contratto(String nome, int renditaTerreno, int renditaUnaCasa, int renditaUnaStazione) {
        this.nome = nome; 
        this.renditaTerreno = renditaTerreno; 
        this.renditaUnaCasa = renditaUnaCasa; 
        this.renditaDueCase = renditaUnaCasa * 2;
        this.renditaTreCase = renditaUnaCasa * 3; 
        this.renditaQuattroCase = renditaUnaCasa * 4; 
        this.renditaAlbergo = renditaUnaCasa * 5; 
        this.renditaUnaStazione = renditaUnaStazione; 
        this.renditaDueStazioni = renditaUnaStazione * 2; 
        this.renditaTreStazioni = renditaUnaStazione * 3; 
        this.renditaQuattroStazioni = renditaUnaStazione * 4; 

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

    public int getRenditaDueCase() {
      return renditaDueCase; 
    }

    public int getRenditaTreCase() {
      return renditaTreCase; 
    }

    public int getRenditaQuattroCase() {
      return renditaQuattroCase; 
    }

    public int getRenditaAlbergo() {
      return renditaAlbergo; 
    }

    public int getRenditaUnaStazione() {
      return renditaUnaStazione; 
    }

    public int getRenditaDueStazioni() {
      return renditaDueStazioni; 
    }

    public int getRenditaTreStazioni() {
      return renditaTreStazioni; 
    }

    public int getRenditaQuattroStazioni() {
      return renditaQuattroStazioni; 
    }


}
