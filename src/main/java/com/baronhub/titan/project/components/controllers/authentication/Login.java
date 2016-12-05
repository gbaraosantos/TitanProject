package com.baronhub.titan.project.components.controllers.authentication;

import com.baronhub.titan.project.components.controllers.homepage.Homepage;
import com.baronhub.titan.project.configurations.session.SpringAccountDetails;
import org.apache.log4j.Level;
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
        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) return "redirect:/weblink";
        return "Login";
    }

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public void init(){

    }
}
