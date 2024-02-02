package com.luca.monopoly.domain;

public class Contratto {
  private String testo;
  private int renditaTerreno;
  private int renditaUnaCasetta;
  private int renditaDueCasette;
  private int renditaTreCasette;
  private int renditaQuattroCasette;
  private int renditaAlbergo;
  private int renditaUnaStazione;
  private int renditaDueStazioni;
  private int renditaTreStazioni;
  private int renditaQuattroStazioni;
  private int tassa;

  public Contratto(String testo, int renditaTerreno, int renditaUnaCasetta, int renditaUnaStazione, int tassa) {
    this.testo = testo;
    this.renditaTerreno = renditaTerreno;
    this.renditaUnaCasetta = renditaUnaCasetta;
    this.renditaDueCasette = renditaUnaCasetta * 2;
    this.renditaTreCasette = renditaUnaCasetta * 3;
    this.renditaQuattroCasette = renditaUnaCasetta * 4;
    this.renditaAlbergo = renditaUnaCasetta * 5;
    this.renditaUnaStazione = renditaUnaStazione;
    this.renditaDueStazioni = renditaUnaStazione * 2;
    this.renditaTreStazioni = renditaUnaStazione * 3;
    this.renditaQuattroStazioni = renditaUnaStazione * 4;
    this.tassa = tassa;

  }

  public String getTesto() {
    return testo;
  }

  public int getRenditaTerreno() {
    return renditaTerreno;
  }

  public int getRenditaUnaCasetta() {
    return renditaUnaCasetta;
  }

  public int getRenditaDueCasette() {
    return renditaDueCasette;
  }

  public int getRenditaTreCasette() {
    return renditaTreCasette;
  }

  public int getRenditaQuattroCasette() {
    return renditaQuattroCasette;
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

  public int getTassa() {
    return tassa;
  }

  public int calcolaAffitto(int numeroCasette) {
    switch (numeroCasette) {
      case 0:
        return this.getRenditaTerreno();
      case 1:
        return this.getRenditaUnaCasetta();
      case 2:
        return this.getRenditaDueCasette();
      case 3:
        return this.getRenditaTreCasette();
      case 4:
        return this.getRenditaQuattroCasette();
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
