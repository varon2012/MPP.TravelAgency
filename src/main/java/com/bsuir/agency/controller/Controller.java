package com.bsuir.agency.controller;

import com.bsuir.agency.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {

    @RequestMapping(value="/")
    public ModelAndView hello(){
        ModelAndView model = new ModelAndView("index");
        model.addObject("users", iPersonService.getAllPersons());
        return model;
    }

    @Autowired
    public void setiTestService(PersonService iPersonService) {
        this.iPersonService= iPersonService;
    }

    private PersonService iPersonService;
}
