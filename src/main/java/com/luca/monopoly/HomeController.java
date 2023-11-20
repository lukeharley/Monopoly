package com.luca.monopoly;

import com.luca.monopoly.domain.Giocatore;
import com.luca.monopoly.domain.Monopoly;
import com.luca.monopoly.domain.Segnalini;

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

        List<Segnalini> segnalini = new Monopoly().getSegnalini();
        model.addAttribute("segnalini", segnalini);

        return "home";

    }

    @PostMapping("/")
    public String aggiungiGiocatore(Model model, HomeForm form) {

        model.addAttribute("form", form);
        model.addAttribute("dadi", new Monopoly().getDadi().size());
        model.addAttribute("nomeGiocatoreAggiunto", form.getNome());
        model.addAttribute("segnalinoScelto", form.getSegnalino());
        model.addAttribute("portafoglioPrimoGiocatoreAggiunto",
                new Giocatore(Segnalini.CANE, 1500, 0).getPortafoglio());

        return "home";
    }

}
