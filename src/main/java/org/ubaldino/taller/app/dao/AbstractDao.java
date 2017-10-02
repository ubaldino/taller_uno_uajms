package org.ubaldino.taller.app.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author ubaldino
 * @param <E>
 */
public abstract class AbstractDao<E extends Serializable> implements EntityDao<E> {

    private final Class<E> entityClass;

    
    public AbstractDao() {
        this.entityClass=(Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public E findById(Serializable id) {
        return (E) getSession().get(entityClass, id);
    }
    
    @Override
    public void save(E entity) {
        getSession().saveOrUpdate(entity);
    }
     
 
    public E findOne( long id ){
       return (E) getCurrentSession().get(this.entityClass,id);
    }
    public List<E> findAll(){
        return getCurrentSession()
        .createQuery("from "+this.entityClass.getName()).list();
    }

    public void create(E entity){
        getCurrentSession().persist(entity);
    }

    public void update(E entity){
       getCurrentSession().merge( entity );
    }

    public void delete( E entity ){
       getCurrentSession().delete( entity );
    }
    public void deleteById( Serializable entityId ) {
       E entity = findById(entityId );
       delete( entity );
    }

    protected final Session getCurrentSession() {
       return sessionFactory.getCurrentSession();
    }
    
}