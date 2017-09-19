package org.ubaldino.taller.app.dao;

import java.util.List;

import org.ubaldino.taller.app.model.User;

public interface UserDaoInterface extends EntityDao<User> {
    @Override
    public void save(User user);
    //public boolean isValidUser(String login, String password) throws SQLException;
    public List<User> list();
}
