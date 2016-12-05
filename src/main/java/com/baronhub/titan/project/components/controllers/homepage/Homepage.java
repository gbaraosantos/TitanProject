package com.baronhub.titan.project.components.controllers.homepage;

import com.baronhub.titan.project.components.services.mailer.Mailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedList;
import java.util.List;

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
        List<String> toSend = new LinkedList<>();
        toSend.add("g.baraosantos@gmail.com");
        mailer.sendEmail("info.baronhub@gmail.com",toSend,"Test","Test","baronhub123");
    }
}
