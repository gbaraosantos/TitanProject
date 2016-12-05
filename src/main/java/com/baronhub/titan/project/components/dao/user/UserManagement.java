package com.baronhub.titan.project.components.dao.user;



import com.baronhub.titan.project.common.exceptions.BaseException;
import com.baronhub.titan.project.components.models.user.User;

/**
 * Methods regarding users
 */
public interface UserManagement {

    /**
     * Fetches a user by email
     * @param email String Unique
     * @return User
     */
    User getUserByEmail(String email) throws BaseException;

    /**
     * Adds a new user to the database
     * @param user User
     */
    void register(User user);

    /**
     * Updates a user
     * @param user User
     */
    void updateUser(User user);

    /**
     * Gets a user by Id
     * @param id Integer
     * @return User
     */
    User getUser(Integer id) throws BaseException;

    /**
     * Deletes a user from the database
     * @param user User
     */
    void deleteUser(User user);



}
