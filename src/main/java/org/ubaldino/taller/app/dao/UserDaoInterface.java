package org.ubaldino.taller.app.dao;

import java.util.List;

import org.ubaldino.taller.app.model.User;

public interface UserDaoInterface extends EntityDao<User> {
    @Override
    public void save(User user);
    
    //User findById(Integer id);
    /*
    public List<User> findAll();
    
    public void update(User user);
    */
    public void delete(String login);
    
    public List<User> list();
}
