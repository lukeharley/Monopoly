package com.luca.monopoly;

import com.luca.monopoly.domain.Monopoly;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(Model model) {

        model.addAttribute("dadi", new Monopoly().getDadi().size());
        model.addAttribute("form", new HomeForm());

        return "home";
    }

    @PostMapping("/")
    public String aggiungiGiocatore(Model model, HomeForm form) {

        model.addAttribute("dadi", new Monopoly().getDadi().size());
        model.addAttribute("form", form);
        model.addAttribute("nomeGiocatoreAggiunto", form.getNome());

        return "home";
    }

}
