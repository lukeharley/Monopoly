package com.luca.monopoly;

import com.luca.monopoly.domain.*;
import com.luca.monopoly.domain.giocatore.Giocatore;
import com.luca.monopoly.domain.giocatore.GiocatoreRisultato;
import com.luca.monopoly.repository.JpaGiocatore;
import com.luca.monopoly.repository.JpaGiocatoreRepository;
import com.luca.monopoly.service.GiocatoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    private GiocatoreService giocatoreService;

    private Monopoly monopoly = new Monopoly();

    @Autowired
    private JpaGiocatoreRepository jpaGiocatoreRepository;

    public HomeController(GiocatoreService partitaService) {
        this.giocatoreService = partitaService;
    }

    @GetMapping("/")
    public String getHome(Model model) {

        model.addAttribute("form", new HomeForm());
        model.addAttribute("dadi", new Monopoly().getDadi().size());
        model.addAttribute("portafoglioPrimoGiocatoreAggiunto",
                new Giocatore("", Segnalini.CANE, 1500, 0).getPortafoglio());

        List<SelectOptionView> segnalini = new ArrayList<>();

        for (Segnalini segnalino : Segnalini.values()) {
            segnalini.add(new SelectOptionView(segnalino.ordinal(), segnalino.getNome()));
        }

        model.addAttribute("segnalini", segnalini);

        return "home";

    }

    @PostMapping("/")
    public String avviaPartita(Model model, HomeForm form) {

        Segnalini segnalino = Segnalini.values()[form.getSegnalino()];
        Giocatore giocatore = new Giocatore("", segnalino, 1500, 0);


        JpaGiocatore giocatoreEsistente = jpaGiocatoreRepository.findBySegnalino(segnalino);
        if (giocatoreEsistente != null) {
            model.addAttribute("segnalinoSelezionato", "Il segnalino selezionato è già stato scelto.");
        } else {
            JpaGiocatore jpaGiocatore = new JpaGiocatore();
            jpaGiocatore.setNome(form.getNome());
            jpaGiocatore.setSegnalino(segnalino);
            jpaGiocatore.setPortafoglio(giocatore.getPortafoglio());
            jpaGiocatore.setPosizione(giocatore.getPosizione());

            jpaGiocatoreRepository.save(jpaGiocatore);
        }


        List<Casella> caselle = new Monopoly().getTabellone().getCaselle();
        // Collections.reverse(caselle);

        model.addAttribute("form", form);
        model.addAttribute("dadi", new Monopoly().getDadi().size());
        model.addAttribute("caselle", caselle);
        model.addAttribute("giocatore", giocatore);
        model.addAttribute("nomeGiocatoreAggiunto", form.getNome());
        model.addAttribute("segnalinoScelto", segnalino.getNome());
        model.addAttribute("portafoglioPrimoGiocatoreAggiunto", giocatore.getPortafoglio());

        List<SelectOptionView> segnalini = new ArrayList<>();

        for (Segnalini element : Segnalini.values()) {
            segnalini.add(new SelectOptionView(element.ordinal(), element.getNome()));
        }

        model.addAttribute("segnalini", segnalini);

        return "home";

    }

    @PostMapping("/lanciaDadi")
    public ResponseEntity<Map<String, Object>> lanciaDadi() {

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

    @PostMapping("/resettaPartita")
    public ResponseEntity<String> resettaPartita() {
        giocatoreService.eliminaGiocatori();
        return ResponseEntity.ok("Giocatori correttamente eliminati!");
    }

}
