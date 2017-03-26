package com.bsuir.mpp.travelagency.controllers;

/**
 * Created by zheny on 3/26/2017.
 */

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloSpring {

    @RequestMapping("/")
    public String helloMethod()
    {
        return "I don't know what fucking happening here";
    }
}
