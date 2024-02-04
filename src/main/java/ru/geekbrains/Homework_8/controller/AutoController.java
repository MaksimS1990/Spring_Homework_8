package ru.geekbrains.Homework_8.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.geekbrains.Homework_8.model.Auto;
import ru.geekbrains.Homework_8.service.AutoService;

@Controller
@AllArgsConstructor
public class AutoController {

    private AutoService autoService;
    /*
    метод получения всех авто
     */
    @GetMapping("/auto")
    public String getAuto(Model model) {
        model.addAttribute("auto", autoService.getAllAutomobiles());
        return "auto";
    }

    /*
    метод добавления авто
     */
    @PostMapping("/auto")
    public String addAuto(Auto a, Model model) {
        autoService.addAuto(a);
        model.addAttribute("auto", autoService.getAllAutomobiles());
        return "auto";
    }
}