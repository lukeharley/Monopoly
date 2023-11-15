package com.luca.monopoly.domain;

public class Contratto {
  private String testo;
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

  public Contratto(String testo, int renditaTerreno, int renditaUnaCasa, int renditaUnaStazione) {
    this.testo = testo;
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

  public String getTesto() {
    return testo;
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

  public int calcolaAffitto(int numeroCasette) {
    switch (numeroCasette) {
      case 0:
        return this.getRenditaTerreno();
      case 1:
        return this.getRenditaUnaCasa();
      case 2:
        return this.getRenditaDueCase();
      case 3:
        return this.getRenditaTreCase();
      case 4:
        return this.getRenditaQuattroCase();
      case 5:
        return this.getRenditaAlbergo();
      default:
        throw new IllegalArgumentException("Numero di casette non valido: " + numeroCasette
            + ". Il numero di casette deve essere compreso tra 0 e 5.");
    }
  }

  @Override
  public String toString() {
    return "Testo: " + testo + " Rendita terreno: " + renditaTerreno + " Rendita una casa: " + renditaUnaCasa
        + " Rendita due case: " + renditaDueCase + " Rendita tre case: " + renditaTreCase + " Rendita quattro case: "
        + renditaQuattroCase + " Rendita alberghi: " + renditaAlbergo + "\n";
  }

}
