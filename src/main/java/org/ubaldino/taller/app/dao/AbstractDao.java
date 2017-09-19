package org.ubaldino.taller.app.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author ubaldino
 * @param <E>
 */
public abstract class AbstractDao<E> implements EntityDao<E> {

    private final Class<E> entityClass;

    @SuppressWarnings("unchecked")
	public AbstractDao() {
        this.entityClass=(Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public E findById(final Serializable id) {
        return (E) getSession().get(entityClass, id);
    }
    
    @Override
    public void save(E entity) {
        getSession().saveOrUpdate(entity);
    }
    
}