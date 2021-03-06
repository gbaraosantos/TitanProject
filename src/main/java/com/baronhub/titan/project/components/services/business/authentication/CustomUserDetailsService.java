package com.baronhub.titan.project.components.services.business.authentication;

import com.baronhub.titan.project.common.enums.State;
import com.baronhub.titan.project.common.exceptions.BaseException;
import com.baronhub.titan.project.components.dao.user.UserManagement;
import com.baronhub.titan.project.components.models.user.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Custom implementation of User Details
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired private UserManagement userDao;
    private static Logger logger = Logger.getLogger(CustomUserDetailsService.class);

    /**
     * Class that will create a UserDetails Object to register a new login with spring security
     * @param email String - Email as in username for authentication
     * @return UserDetails
     */

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String email){
        try {

            User user = userDao.getUserByEmail(email);

            return new org.springframework.security.core.userdetails.User(
                                user.getEmail(),
                                user.getPassword(),
                                user.getState().equals(State.ACTIVE.getState()),
                                true,
                                true,
                                true,
                                getGrantedAuthorities(user));

        } catch (BaseException exception) {
            logger.error("Error Authenticating", exception);
            return null;
        }
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user){
        return  user.getUserPermissions()
                    .stream()
                    .map(userProfile -> new SimpleGrantedAuthority("ROLE_" + userProfile.getType()))
                    .collect(Collectors.toList());
    }

}
