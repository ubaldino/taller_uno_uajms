package org.ubaldino.taller.app.service;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.javalite.activejdbc.Base;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.ubaldino.taller.app.model.Profile;
import org.ubaldino.taller.app.model.Role;

import org.ubaldino.taller.app.model.User;

/**
 * @author Ubaldino Zurita
 *
 */
@Service
public class UserService {
    
   @Autowired DataSource dataSource;
    //@Autowired
    //private PasswordEncoder passwordEncoder;

    public User get(String login){
        if(!Base.hasConnection()) Base.open();
        User user=new User();
        try {
            user = user.findFirst("login=?",login);
        } catch (Exception e) {
            user=null;
        }
        return user;
    }
    
    public List<Map<String,Object>> getAll() {
        if(!Base.hasConnection()) Base.open();
        List<Map<String,Object>> users = null;
        try{
            Base.openTransaction();
            users=User.findAll()
                    .include(Profile.class,Role.class)
                    .toMaps();
            Base.commitTransaction();
        }catch( Exception e){
            Base.rollbackTransaction();
        }
         
        return users;
    }
    
}
