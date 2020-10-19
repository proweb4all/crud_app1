package ru.proweb4all.crudapp1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.proweb4all.crudapp1.dao.PersonDAO;
import ru.proweb4all.crudapp1.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleControllers {

    private PersonDAO personDAO;

    public PeopleControllers(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @GetMapping()
    public String index(Model model) {
        // Получим всех людей из DAO и передадим на отображение в представление
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        // Получим человека по id из DAO и передадим на отображение в представление
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("person") Person person) {
        personDAO.save(person);
        return "redirect:/people";
    }
}
