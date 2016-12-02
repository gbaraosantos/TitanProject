package com.baronhub.titan.project.components.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Database Abstract connection
 */
public abstract class AbstractDao<PK extends Serializable, T> {
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
     * Fetch using Primary Key
     */

    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }

    /**
     * Add Object
     */
    public void persist(T entity) {
        getSession().persist(entity);
    }

    /**
     * Saves Object
     */
    public void save(T entity) {getSession().save(entity);}

    /**
     * Updates Object
     */
    public void update(T entity) {
        getSession().update(entity);
    }

    /**
     * Deletes Object
     */
    public void delete(T entity) {
        getSession().delete(entity);
    }

    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }

}
