package org.ubaldino.taller.app.dao;

import java.util.List;

import org.ubaldino.taller.app.model.User;

public interface UserDao {
   void save(User user);
   List<User> list();
}
