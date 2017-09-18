package org.ubaldino.taller.app.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.ubaldino.taller.app.model.User;
import org.ubaldino.taller.app.dao.UserDaoInterface;

/**
 * @author Ubaldino Zurita
 *
 */
@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserDaoInterface userDao;

    public UserDaoInterface getUserDao(){
        return this.userDao;
    }

    public void setUserDao(UserDaoInterface userDao){
        this.userDao = userDao;
    }
    
    @Transactional
    @Override
    public void save(User user) {
       userDao.save(user);
    }

    @Transactional(readOnly=true)
    @Override
    public List<User> list() {
       return userDao.list();
    }
    
    @Transactional
    @Override
    public boolean isValidUser(String login, String password) throws SQLException {
        return userDao.isValidUser(login, password);
    }
    
}
