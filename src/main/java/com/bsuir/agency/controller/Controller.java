package com.bsuir.agency.controller;

import com.bsuir.agency.entity.PersonEntity;
import com.bsuir.agency.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {

    @RequestMapping(value="/reg", method = RequestMethod.POST)
    public ResponseEntity<PersonEntity> createUser(@RequestBody PersonEntity user){
        iPersonService.create(user);
        return new ResponseEntity<PersonEntity>(new PersonEntity(), HttpStatus.OK);
    }

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
