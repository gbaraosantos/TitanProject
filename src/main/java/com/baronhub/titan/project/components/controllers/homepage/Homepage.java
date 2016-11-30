package com.baronhub.titan.project.components.controllers.homepage;

import com.baronhub.titan.project.components.services.mailer.Mailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Homepage Controller
 */

@Controller
public class Homepage {
    @Autowired private Mailer mailer;
    /**
     * Testing Controller
     */

    @RequestMapping(value = "/teste" , method = RequestMethod.GET)
    void teste(){
    }
}
