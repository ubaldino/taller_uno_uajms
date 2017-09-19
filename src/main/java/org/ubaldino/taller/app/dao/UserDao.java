package org.ubaldino.taller.app.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.ubaldino.taller.app.model.User;

/**
 * @author Ubaldino Zurita
 */
@Repository
public class UserDao extends AbstractDao<User> implements UserDaoInterface {

    @Autowired
    private DataSource dataSource ;
    
    
    public DataSource getDataSource(){
        return this.dataSource;
    }

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    @Override
    public List<User> list() {
        @SuppressWarnings("unchecked")
		TypedQuery<User> query = this.getSession().createQuery("from User");
        return query.getResultList();
    }
}
