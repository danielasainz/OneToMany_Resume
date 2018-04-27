package com.sainz.onetomanyresume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {


    @Autowired
    PersonRepository personRepo;

    @Autowired
    ExperienceRepository experienceRepo;

    public String showIndex() {
        return "index";
    }

    @GetMapping("/add")
    public String addExperience(Model model) {
        model.addAttribute("aExperience", new Experience());
        model.addAttribute("personslist", personRepo.findAll());
        return "addExperience";
    }

    @PostMapping("/save")
    public String saveExperience(@ModelAttribute("aExperience") Experience experienceToSave, Model model) {
        experienceRepo.save(experienceToSave);
        return "redirect:/list";
    }


    @GetMapping("/list")
    public String listExperience(Model model) {
        model.addAttribute("experienceslist", experienceRepo.findAll());
        return "listExperience";
    }

    @GetMapping("/addperson")
    public String addPerson(Model model) {
        model.addAttribute("aPerson", new Person());
        return "addPerson";
    }

    @PostMapping("/saveperson")
    public String savePerson(@ModelAttribute("aPerson") Person personToSave, Model model) {
        personRepo.save(personToSave);
        return "redirect:/listperson";
    }

    @GetMapping("/listperson")
    public String listPerson(Model model) {
        model.addAttribute("personslist", personRepo.findAll());
        return "listPerson";
    }


    @RequestMapping("/updateperson/{id}")
    public String updatePerson(@PathVariable("id") long id, Model model) {
        model.addAttribute("aPerson", personRepo.findById(id).get());
        return "addPerson";
    }

    /*

    @RequestMapping("/changestatus/{id}")
    public String changeStatus(@PathVariable("id") long id) {
        Experience thisExperience = experienceRepo.findById(id).get();
        experienceRepo.save(thisExperience);
        return "redirect:/list";
    } */

    @RequestMapping("/update/{id}")
    public String updateExperience(@PathVariable("id") long id, Model model) {
        model.addAttribute("aExperience", experienceRepo.findById(id).get());
        model.addAttribute("personslist", personRepo.findAll());
        return "addExperience";
    }
}