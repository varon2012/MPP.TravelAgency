package com.bsuir.agency.controller;


import com.bsuir.agency.bean.Test;

import com.bsuir.agency.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {


    @RequestMapping(value="/hello")
    public Test HelloVRot() {
        return iTestService.getTest();
    }

    @RequestMapping(value="/index")
    public ModelAndView hello(){
        ModelAndView model = new ModelAndView("index");
        List<String> list = new ArrayList<String>();
        list.add("asfasf");
        list.add("122423");
        model.addObject("users", iTestService.getTests());
        return model;
    }

    @Autowired
    public void setiTestService(IService iTestService) {
        this.iTestService= iTestService;
    }

    private IService iTestService;
}
