package ru.sheve.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sheve.springmvc.dao.PersonDAO;
import ru.sheve.springmvc.model.Person;

@Controller
@RequestMapping("/people")
public class PersonController {

    private final PersonDAO personDAO;

    @Autowired
    public PersonController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String show(Model model) {
        model.addAttribute("people", personDAO.show());
        return "person/show";
    }

    @GetMapping("/{id}")
    public String index(@PathVariable("id") int id,
                        Model model) {
        model.addAttribute("people", personDAO.index(id));
        return "person/index";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("people") Person person) {
        return "person/new";
    }

    @PostMapping()
    public String add(@ModelAttribute("people") Person person) {
        personDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id,
                       Model model) {
        model.addAttribute("people", personDAO.index(id));
        return "person/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id,
                         @ModelAttribute("people") Person person) {
        personDAO.update(person, id);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }
}
