package org.ubaldino.taller.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ubaldino.taller.app.dao.UserDao;

import org.ubaldino.taller.app.model.User;

/**
 * @author Ubaldino Zurita
 *
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
    
    @Transactional
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Transactional(readOnly=true)
    public List<User> list() {
       return userDao.findAll();
    }
    
    @Transactional
    public User getUser(String login) {
        return userDao.findById(login);
    }
    
    @Transactional
    public void deleteUser(String login) {
        userDao.deleteById(login);
    }
}
