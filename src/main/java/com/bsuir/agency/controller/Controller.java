package com.bsuir.agency.controller;


import com.bsuir.agency.bean.Test;

import com.bsuir.agency.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @RequestMapping(value="/hello")
    public Test HelloVRot() {
        return iTestService.getTest();
    }


    @Autowired
    public void setiTestService(IService iTestService) {
        this.iTestService= iTestService;
    }

    private IService iTestService;
}
