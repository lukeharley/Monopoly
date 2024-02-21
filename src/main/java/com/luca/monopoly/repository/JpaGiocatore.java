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

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "segnalino", unique = true)
    private Segnalini segnalini;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Segnalini getSegnalini() {
        return segnalini;
    }

    public void setSegnalini(Segnalini segnalini) {
        this.segnalini = segnalini;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
}
