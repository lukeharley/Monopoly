package com.luca.monopoly;

import com.luca.monopoly.domain.Giocatore;
import com.luca.monopoly.domain.Monopoly;
import com.luca.monopoly.domain.Segnalini;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(Model model) {

        model.addAttribute("form", new HomeForm());
        model.addAttribute("dadi", new Monopoly().getDadi().size());
        model.addAttribute("portafoglioPrimoGiocatoreAggiunto",
                new Giocatore(Segnalini.CANE, 1500, 0).getPortafoglio());

        List<SelectOptionView> segnalini = new ArrayList<>();

        for (Segnalini segnalino : Segnalini.values()) {
            segnalini.add(new SelectOptionView(segnalino.ordinal(), segnalino.getNome()));
        }

        model.addAttribute("segnalini", segnalini);

        return "home";

    }

    @PostMapping("/")
    public String aggiungiGiocatore(Model model, HomeForm form) {

        model.addAttribute("form", form);
        model.addAttribute("dadi", new Monopoly().getDadi().size());
        model.addAttribute("nomeGiocatoreAggiunto", form.getNome());
        model.addAttribute("segnalinoScelto", Segnalini.values()[form.getSegnalino()].getNome());
        model.addAttribute("portafoglioPrimoGiocatoreAggiunto",
                new Giocatore(Segnalini.CANE, 1500, 0).getPortafoglio());

        List<SelectOptionView> segnalini = new ArrayList<>();

        for (Segnalini segnalino : Segnalini.values()) {
            segnalini.add(new SelectOptionView(segnalino.ordinal(), segnalino.getNome()));
        }

        model.addAttribute("segnalini", segnalini);

        return "home";
    }

}
