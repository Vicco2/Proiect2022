package com.example.controller;

import com.example.model.Biblioteci;
import com.example.model.Carti;
import com.example.service.AllService;
//import com.example.service.BiblioteciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class IndexController {

 @Autowired
 AllService service;
/* @Autowired
 BiblioteciService service;*/
//CartiService service = new CartiService();


    @GetMapping(value="/index")
    public String getIndex(Model model){

        return "index";
    }

    @GetMapping(value="/carti")
    public String getCarti(Model model) {



       /* List<Carti> cartiList = List.of(
                new Carti("Don Quixote de La Mancha", 1620, "Miguel de Cervantes", 269 ),
                new Carti("The Call of Cthulhu", 1926, "H. P. Lovecraft", 160 ),
                new Carti("At the Mountains of Madness", 1931 , "H. P. Lovecraft", 225 ),
                new Carti("The Good Soldier Schweik", 1921 , "Jaroslav Hašek", 276 ),
                new Carti("Great Teacher Onizuka Vol 22", 1997  , "Tooru Fujisawa", 120 )

        );*/
        model.addAttribute("cartiList", service.getCartiList());
       // model.addAttribute("ListaCarti", cartiList);

        return "carti";
    }

    @GetMapping(value="/biblioteci")
    public String getBiblioteci(Model model) {

        /*List<Biblioteci> biblioteciList = List.of(
                new Biblioteci("Biblioteca Liceului de Arte Regina Maria ","Alba Iulia" ),
                new Biblioteci("Biblioteca Municipală „Ștefan Luchian” ","Moinești" ),
                new Biblioteci("Biblioteca Universității Transilvania","Brasov" ),
                new Biblioteci("Biblioteca Institutului de Matematică „Simion Stoilow” al Academiei Române","Bucuresti" )

        );*/

        model.addAttribute("ListaBiblioteci",service.getBiblioteciList());
        model.addAttribute("cartiList", service.getCartiList());


        return "biblioteci";

    }

    @GetMapping(value="/createBiblioteci")
    public String createBiblioteci(Model model){
        Biblioteci biblioteci = new Biblioteci();
        model.addAttribute("biblioteci",biblioteci);
        return "formPageBiblioteci";
    }

    @GetMapping(value="/createCarti")
    public String createCarti(Model model){
        Carti carti = new Carti();
    model.addAttribute("carti",carti);
        return "formPage";
    }

    @PostMapping(value="/submitCarti")
    public String submitCarti(@ModelAttribute Carti carti){
        System.out.println(carti.getNume());
        System.out.println(carti.getAn());
        System.out.println(carti.getScriitor());
        System.out.println(carti.getPret());
        service.saveCarti(carti);

      //  repository.save(carti);
        return "redirect:/index";


    }
    @PostMapping(value="/submitBiblioteci")
    public String submitBiblioteci(@ModelAttribute Biblioteci biblioteci){
        System.out.println(biblioteci.getNumeBiblioteca());
        System.out.println(biblioteci.getLoc());
        service.saveBiblioteci(biblioteci);

        //  repository.save(carti);
        return "redirect:/index";


    }
}

