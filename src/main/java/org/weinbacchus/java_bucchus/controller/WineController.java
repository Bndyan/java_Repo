package org.weinbacchus.java_bucchus.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.weinbacchus.java_bucchus.model.Country;
import org.weinbacchus.java_bucchus.model.Wine;
import org.weinbacchus.java_bucchus.repositories.CountryRepository;
import org.weinbacchus.java_bucchus.repositories.WineRepository;

import java.util.List;

/**
 * Die Klasse WineController
 *
 * Repository
 *
 * Das Repository Pattern ist ein Entwurfsmuster, das eine Möglichkeit bietet, die Datenzugriffslogik
 * an einem zentralen Ort zu verwalten. Es trennt die Logik, die die Daten abruft und sie dem
 * Entitätsmodell zuordnet, von der Geschäftslogik, die das Modell bearbeitet.
 * Das Hauptziel des Repository-Musters besteht darin, den Datenzugriffscode zu vereinfachen
 * und eine sauberere Architektur für die Anwendung zu erreichen.
 *
 * @author k.bndyan
 * @version 1.0
 * @date 28.11.2024
 */
@Controller
public class WineController {
    private WineRepository wineRepo;
    private CountryRepository countryRepo;

    @Autowired
    public WineController(WineRepository wineRepo ,CountryRepository countryRepo){
        this.wineRepo = wineRepo;
        this.countryRepo = countryRepo;
    }
    @GetMapping("/edit")
    public String showWineEditForm(@RequestParam long id, Model model){
        Wine wine = wineRepo.findByIdWine(id);
        model.addAttribute("wine",wine);
        return "wine_form";
    }

    @GetMapping("/delete")
    public String deleteWine(@RequestParam long id){
        wineRepo.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/details")
    public String showWineDetails(@RequestParam long id, Model model){
        Wine wine = wineRepo.findByIdWine(id);
        model.addAttribute(wine);
        return "wine_details";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        Wine wine = new Wine();
        model.addAttribute(wine);
        List<Country> countries = countryRepo.findAll(Sort.by("name"));
        model.addAttribute(countries);
        return "wine_form";
    }

    @PostMapping("/save")
    public String saveWine(@ModelAttribute Wine wine, @RequestParam String action){
        if(action.equals("save")) {
            wineRepo.save(wine);
        }
        return "redirect:/";
    }

    @GetMapping("/")
    public String showWineList(Model model){
        // Alle Datensätze abfragen
        List<Wine> wineList = wineRepo.findAll();
        // Filtern nach name
//        List<Wine> wineList = wineRepo.findAll(Sort.by("name")); // رێک خستنی  A - Z
        // Filtern nach Jahrgang und name
//        List<Wine> wineList = wineRepo.findAll(Sort.by("vintage", "name"));
        // Filtern nach
//        List<Wine> wineList = wineRepo.findAll(Sort.by(Sort.Direction.DESC,"vintage", "name"));
        // Filtern nach Jahrgang
//        List<Wine> wineList = wineRepo.findByVintage(2008);
        // suche nach name
//        List<Wine> wineList = wineRepo.findByNameContaining("Brut");

        model.addAttribute("wineList", wineList);
        return "wine_list";
    }
















}
