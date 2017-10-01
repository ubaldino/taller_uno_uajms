package org.ubaldino.taller.app.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import org.ubaldino.taller.app.model.User;

/**
 * @author Ubaldino Zurita
 */
@Repository
public class UserDao extends AbstractDao<User> implements UserDaoInterface {
    @Override
    public List<User> list() {  
        @SuppressWarnings("JPQLValidation")
        TypedQuery<User> query = this.getSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void delete(String login) {
        this.getSession().delete(login, this);
    }
}
