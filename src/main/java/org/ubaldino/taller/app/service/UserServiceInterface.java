package org.ubaldino.taller.app.service;

import java.sql.SQLException;
import java.util.List;

import org.ubaldino.taller.app.model.User;

public interface UserServiceInterface {
   public void save(User user);
   public boolean isValidUser(String login, String password) throws SQLException;
   public List<User> list();
}
