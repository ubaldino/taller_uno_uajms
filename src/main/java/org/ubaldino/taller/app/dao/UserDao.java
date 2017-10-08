package org.ubaldino.taller.app.dao;

import org.springframework.stereotype.Repository;
import org.ubaldino.taller.app.model.User;
import org.hibernate.query.Query;
/**
 * @author Ubaldino Zurita
 */
@Repository
public class UserDao extends AbstractDao<User> {
    
    
    public User findByLogin(String login) {
        Query query = this.getSession().createQuery("FROM User WHERE login=:login");
        query.setParameter("login",login);
        User user =(User) query.uniqueResult(); 
        return user;
    }
    
}
