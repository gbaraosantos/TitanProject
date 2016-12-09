package com.baronhub.titan.project.components.controllers.authentication;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Login Servlet
 */
@Controller
public class Login {
    private static Logger logger = Logger.getLogger(Login.class);
    /**
     * Handles Login
     * @return String
     */
    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public String redirectLogin(){

        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) return "redirect:/titan";
        return "Login";
    }

    /**
     * Platforms initial State
     */
    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public void init(){
        logger.info("Not developed yet",  new Exception("Not developed"));
    }
}
