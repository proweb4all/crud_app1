package ru.proweb4all.crudapp1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleControllers {
    @GetMapping()
    public String index(Model model) {
        // Получим всех людей из DAO и передадим на отображение в представление
        return null;
    }
    @GetMapping("/{id}")
    public  String show(@PathVariable("id") int id, Model model) {
        // Получим человека по id из DAO и передадим на отображение в представление
        return null;
    }

}
