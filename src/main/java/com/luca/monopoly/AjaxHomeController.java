package com.luca.monopoly;

import com.luca.monopoly.domain.*;
import com.luca.monopoly.domain.giocatore.Giocatore;
import com.luca.monopoly.domain.giocatore.GiocatoreRisultato;
import com.luca.monopoly.service.GiocatoreService;
import com.luca.monopoly.service.MonopolyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AjaxHomeController {

    @Autowired
    private GiocatoreService giocatoreService;

    @Autowired
    private MonopolyService monopolyService;

    @PostMapping("/lanciaDadi")
    public ResponseEntity<Map<String, Object>> lanciaDadi() {

        Monopoly monopoly = monopolyService.getMonopoly();

        List<Giocatore> giocatori = monopoly.getGiocatori();

        /*
         * Giocatore giocatore1 = giocatori.get(0);
         * Giocatore giocatore2 = giocatori.get(1);
         */

        Giocatore giocatoreCorrente = giocatori.get(0);

        Tabellone tabellone = monopoly.getTabellone();
        List<Casella> caselle = tabellone.getCaselle();
        List<Contratto> contratti = tabellone.getContratti();
        Map<String, Giocatore> proprietariDeiContratti = tabellone.getProprietariDeiContratti();
        List<Probabilita> probabilita = tabellone.getProbabilita();
        List<Imprevisto> imprevisti = tabellone.getImprevisti();

        Map<String, Object> response = new HashMap<>();

        int risultatoDado = giocatoreService.ottieniRisultatoDado();
        GiocatoreRisultato giocatoreRisultato = giocatoreService.ottieniNuovaPosizioneENuovoPortafoglio(
                risultatoDado, proprietariDeiContratti, caselle, contratti, imprevisti,
                probabilita, giocatoreCorrente);

        response.put("result", "Dadi lanciati con successo!");
        response.put("risultatoDado", risultatoDado);
        response.put("posizione", giocatoreRisultato.getNuovaPosizione());
        response.put("portafoglio", giocatoreRisultato.getNuovoPortafoglio());
        response.put("bancarotta", giocatoreRisultato.isInBancarotta());

        return ResponseEntity.ok(response);

    }
}
