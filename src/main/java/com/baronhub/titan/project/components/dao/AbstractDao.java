package com.baronhub.titan.project.components.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 *
 * @param <pk> Generic Type / Serializable Object
 * @param <T> Generic Type
 */
public abstract class AbstractDao<pk extends Serializable, T> {
    @Autowired private SessionFactory sessionFactory;
    private final Class<T> persistentClass;

    /**
     * Starts up Persistent Class
     */

    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    /**
     *
     * @param key Primary Key
     * @return returns Object from database
     */

    @SuppressWarnings("unchecked")
    public T getByKey(pk key) {
        return (T) getSession().get(persistentClass, key);
    }

    /**
     * Add new Object to database
     * @param entity Entity of an Object
     */
    public void persist(T entity) {
        getSession().persist(entity);
    }

    /**
     * Saves Object
     * @param entity Object
     */
    public void save(T entity) {getSession().save(entity);}

    /**
     * Updates database object
     * @param entity Object to be updated
     */
    public void update(T entity) {
        getSession().update(entity);
    }

    /**
     * Deletes Object from database
     * @param entity Object to be deleted
     */
    public void delete(T entity) {
        getSession().delete(entity);
    }

    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }

}
