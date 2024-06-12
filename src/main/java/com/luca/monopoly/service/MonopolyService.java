package com.luca.monopoly.service;

import com.luca.monopoly.domain.Monopoly;
import org.springframework.stereotype.Service;

@Service
public class MonopolyService {

    private final Monopoly monopoly = new Monopoly();

    public Monopoly getMonopoly() {
        return monopoly;
    }
}
