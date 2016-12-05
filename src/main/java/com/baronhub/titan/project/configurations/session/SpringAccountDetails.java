package com.baronhub.titan.project.configurations.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * Session Mappings
 */
@Component
public class SpringAccountDetails {
    @Autowired private SessionRegistry sessionRegistry;
    /**
     * Returns the username
     * @return Username
     */
    public String getUser() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }

    /**
     * Returns the user names of all users logged in
     * @return List<String> Usernames
     */
    public List<String> getListUsers(){
        List<Object> principals = sessionRegistry.getAllPrincipals();
        List<String> userList = new LinkedList<>();

        for (Object principal: principals) {
            if (principal instanceof UserDetails) userList.add(((UserDetails) principal).getUsername());
            else userList.add(principal.toString());
        }

        return userList;
    }
}
