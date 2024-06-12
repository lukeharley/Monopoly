package com.luca.monopoly.repository;

import com.luca.monopoly.domain.Segnalini;
import jakarta.persistence.*;

@Entity
@Table(name = "giocatore")
public class JpaGiocatore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "segnalino", unique = true)
    private Segnalini segnalino;

    @Column(name = "portafoglio")
    private Integer portafoglio;

    @Column(name = "posizione")
    private Integer posizione;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPortafoglio() {
        return portafoglio;
    }

    public void setPortafoglio(Integer portafoglio) {
        this.portafoglio = portafoglio;
    }

    public Integer getPosizione() {
        return posizione;
    }

    public void setPosizione(Integer posizione) {
        this.posizione = posizione;
    }

    public Segnalini getSegnalino() {
        return segnalino;
    }

    public void setSegnalino(Segnalini segnalino) {
        this.segnalino = segnalino;
    }
}
