package com.luca.monopoly;

import com.luca.monopoly.domain.Casella;
import com.luca.monopoly.domain.Segnalini;
import com.luca.monopoly.domain.giocatore.Giocatore;
import com.luca.monopoly.repository.JpaGiocatore;
import com.luca.monopoly.repository.JpaGiocatoreRepository;
import com.luca.monopoly.service.GiocatoreService;
import com.luca.monopoly.service.MonopolyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private GiocatoreService giocatoreService;

    @Autowired
    private MonopolyService monopolyService;

    @Autowired
    private JpaGiocatoreRepository jpaGiocatoreRepository;

    @GetMapping("/")
    public String getHome(Model model) {

        model.addAttribute("form", new HomeForm());
        model.addAttribute("dadi", monopolyService.getMonopoly().getDadi().size());
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


        List<Casella> caselle = monopolyService.getMonopoly().getTabellone().getCaselle();
        // Collections.reverse(caselle);

        model.addAttribute("form", form);
        model.addAttribute("dadi", monopolyService.getMonopoly().getDadi().size());
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

    @GetMapping("/resettaPartita")
    public String resettaPartita() {
        giocatoreService.eliminaGiocatori();
        return "redirect:/";
    }

}
