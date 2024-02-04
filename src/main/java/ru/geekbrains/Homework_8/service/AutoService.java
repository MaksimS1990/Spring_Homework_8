package ru.geekbrains.Homework_8.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.Homework_8.aspects.ToLog;
import ru.geekbrains.Homework_8.model.Auto;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class AutoService {

    private Logger logger = Logger.getLogger(AutoService.class.getName());

    List<Auto> automobiles = new ArrayList<>();

    /*
    метод добавления продуктв
     */

    @ToLog
    public void addAuto(Auto automobile) {
        automobiles.add(automobile);
    }


    /*
    метод получения всех продуктов
     */

    public List<Auto> getAllAutomobiles() {
        return automobiles;
    }

}