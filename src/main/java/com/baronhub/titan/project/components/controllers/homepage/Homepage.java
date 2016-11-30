package com.baronhub.titan.project.components.controllers.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Homepage Controller
 */

@Controller
public class Homepage {
    /**
     * Testing Controller
     */

    @RequestMapping(value = "/teste" , method = RequestMethod.GET)
    void teste(){
        System.out.println("Here");
    }
}
