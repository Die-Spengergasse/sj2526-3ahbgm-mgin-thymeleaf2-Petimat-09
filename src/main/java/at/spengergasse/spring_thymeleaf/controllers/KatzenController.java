package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.Katzen;
import at.spengergasse.spring_thymeleaf.entities.KatzenRepository;
import at.spengergasse.spring_thymeleaf.entities.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/katzen")
public class KatzenController {
    private final KatzenRepository katzenRepository;

    public KatzenController(KatzenRepository katzenRepository) {
        this.katzenRepository = katzenRepository;
    }

    @GetMapping("/list")
    public String katzen(Model model) {
        model.addAttribute("katzen", katzenRepository.findAll());
        return "katzen";
    }

    @GetMapping("/add")
    public String addKatzen(Model model) {
        model.addAttribute("katzen", new Katzen());
        return "add_katzen";
    }

    @PostMapping("/add")
    public String addKatzen(@ModelAttribute("katzen") Katzen katzen) {
        katzenRepository.save(katzen);
        return "redirect:/katzen/list";}
}
