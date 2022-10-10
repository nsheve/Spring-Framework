package ru.sheve.springcours.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sheve.springcours.dao.PersonDAO;

@Controller
@RequestMapping("/test-batch-update")
public class BatchUpdate {

    private final PersonDAO personDAO;

    @Autowired
    public BatchUpdate(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping
    public String index() {
        return "batch/index";
    }

    @GetMapping("/without")
    public String without() {
        personDAO.testMultipleUpdate();
        return "redirect:/people";
    }

    @GetMapping("/with")
    public String withoutBatch() {
        personDAO.testBatchUpdate();
        return "redirect:/people";
    }
}
