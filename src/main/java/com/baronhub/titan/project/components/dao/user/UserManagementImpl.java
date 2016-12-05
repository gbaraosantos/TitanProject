package com.baronhub.titan.project.components.dao.user;

import com.baronhub.titan.project.common.exceptions.BaseException;
import com.baronhub.titan.project.components.dao.AbstractDao;
import com.baronhub.titan.project.components.models.User;
import org.springframework.stereotype.Repository;

/**
 * UserManagement Implementation
 */

@Repository("userManagementDao")
public class UserManagementImpl extends AbstractDao<Integer, User, String> implements  UserManagement{
    /**
     * Fetches a user by email
     * @param email String Unique
     * @return User
     */
    @Override
    public User getUserByEmail(String email) throws BaseException {
        return getOne(getByValue("email" , email));

    }

    /**
     * Adds a new user to the database
     * @param user User
     */
    @Override
    public void register(User user) {
        persist(user);
    }

    /**
     * Updates a user
     * @param user User
     */
    @Override
    public void updateUser(User user) {
        update(user);
    }

    /**
     * Gets a user by Id
     * @param id Integer
     * @return User
     */
    @Override
    public User getUser(Integer id) throws BaseException {
        return getByKey(id);
    }

    /**
     * Deletes a user from the database
     * @param user User
     */
    @Override
    public void deleteUser(User user) {
        delete(user);
    }
}
