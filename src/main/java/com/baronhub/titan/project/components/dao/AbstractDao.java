package com.baronhub.titan.project.components.dao;

import com.baronhub.titan.project.common.exceptions.BaseException;
import com.baronhub.titan.project.common.exceptions.Database;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 *
 * @param <P1> Generic Type / Serializable Object - Expecting primary Key Type
 * @param <P2> Generic Type / Serializable Object - Expecting another object type to query for
 * @param <T> Generic Type
 */
public abstract class AbstractDao<P1 extends Serializable, T , P2 extends Serializable> {
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
     * @param key Primary Key
     * @return returns Object from database
     */
    @SuppressWarnings("unchecked")
    protected T getByKey(P1 key) throws BaseException{
        T temp = (T) getSession().get(persistentClass, key);
        if(temp == null) throw new Database.NoElementsException("No elements in this query");
        return temp;
    }

    /**
     * Gets an object by key
     * @param propertyName Name of the property
     * @param value Value of the property
     * @return List
     */
    @SuppressWarnings("unchecked")
    protected List<T> getByValue(String propertyName, P2 value) throws BaseException{
        Criteria cr = getSession().createCriteria(persistentClass);
        cr.add(Restrictions.eq(propertyName, value));

        if( cr.list()==null ||  cr.list().isEmpty()){
            throw new Database.NoElementsException("No elements in this query");
        }

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
        if(list==null || list.isEmpty()){
            throw new Database.NoElementsException("No elements in this query");
        }
        if(list.size() > 1){
            throw new Database.MoreThanExpectedException("Query returned more than one element");
        }
        return list.get(0);
    }


    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }

}
