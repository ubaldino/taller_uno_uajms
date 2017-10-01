/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ubaldino.taller.app.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.ubaldino.taller.app.model.Role;

/**
 *
 * @author ubaldino
 */
public class RoleDao implements RoleDaoInterface{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void save(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }

    @Override
    public List<Role> list() {
        
        @SuppressWarnings("JPQLValidation")
        TypedQuery<Role> query = sessionFactory.getCurrentSession().createQuery("from Role");
        return query.getResultList();
    }
    
}
