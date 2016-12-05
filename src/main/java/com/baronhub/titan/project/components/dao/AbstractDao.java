package com.baronhub.titan.project.components.dao;

import com.baronhub.titan.project.common.exceptions.BaseException;
import com.baronhub.titan.project.common.exceptions.DatabaseExceptions;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

/**
 *
 * @param <P1> Generic Type / Serializable Object - Expecting primary Key Type
 * @param <T> Generic Type
 */
public abstract class AbstractDao<P1 extends Serializable, T> {
    @Autowired private SessionFactory sessionFactory;
    private final Class<T> persistentClass;
    private static final String EMPTY_QUERY = "No Elements in this query";

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
     * @param key Primary Key
     * @return returns Object from database
     */
    @SuppressWarnings("unchecked")
    protected T getByKey(P1 key) throws BaseException{
        T temp = (T) getSession().get(persistentClass, key);
        if(temp == null) throw new DatabaseExceptions.NoElementsException(EMPTY_QUERY);
        return temp;
    }

    /**
     * Gets an object by key
     * @param propertyName Name of the property
     * @param value Value of the property
     * @return List
     */
    @SuppressWarnings("unchecked")
    protected List<T> getByString(String propertyName, String value) throws BaseException{
        Criteria cr = getSession().createCriteria(persistentClass);
        cr.add(Restrictions.eq(propertyName, value));
        if( cr.list()==null ||  cr.list().size() <= 0) throw new DatabaseExceptions.NoElementsException(EMPTY_QUERY);

        return (List<T>) cr.list();
    }

    /**
     * Gets an object by key
     * @param propertyName Name of the property
     * @param from Value of the initial date
     * @param to Value of the final date
     * @return List
     */
    @SuppressWarnings("unchecked")
    protected List<T> getByDate(String propertyName, Date from, Date to) throws BaseException{
        Criteria cr = getSession().createCriteria(persistentClass);
        cr.add(Restrictions.between(propertyName, from , to));
        if( cr.list()==null ||  cr.list().size() <= 0) throw new DatabaseExceptions.NoElementsException(EMPTY_QUERY);

        return (List<T>) cr.list();
    }

    /**
     * Add new Object to database
     * @param entity Entity of an Object
     */
    protected void persist(T entity) {
        getSession().persist(entity);
    }

    /**
     * Saves Object
     * @param entity Object
     */
    protected void save(T entity) {getSession().save(entity);}

    /**
     * Updates database object
     * @param entity Object to be updated
     */
    protected void update(T entity) {
        getSession().update(entity);
    }

    /**
     * Deletes Object from database
     * @param entity Object to be deleted
     */
    protected void delete(T entity) {
        getSession().delete(entity);
    }

    /**
     *
     * @param list Gets List
     * @return One Element
     * @throws BaseException Exception returns
     */
    protected T getOne(List<T> list) throws BaseException{
        if(list==null || list.isEmpty()) throw new DatabaseExceptions.NoElementsException(EMPTY_QUERY);
        if(list.size() > 1) throw new DatabaseExceptions.MoreThanExpectedException("Query returned more than one element");

        return list.get(0);
    }


    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }

}
