package org.ubaldino.taller.app.service;

import java.util.List;

import org.ubaldino.taller.app.model.User;

public interface UserService {
   void save(User user);

   List<User> list();
}
