package org.ubaldino.taller.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.ubaldino.taller.app.model.User;
import org.ubaldino.taller.app.dao.UserDaoInterface;

/**
 * @author Ubaldino Zurita
 *
 */
@Service("userService")
public class UserService implements UserServiceInterface {

    @Autowired
    private UserDaoInterface userDao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void setUserDao(UserDaoInterface userDao){
        this.userDao = userDao;
    }
    
    @Transactional
    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Transactional(readOnly=true)
    @Override
    public List<User> list() {
       return userDao.list();
    }
    
    @Override
    public User getUser(String login) {
        return userDao.findById(login);
    }    
}
