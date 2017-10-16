package org.ubaldino.taller.app.service;

import java.util.List;
import java.util.Map;
import org.javalite.activejdbc.Base;

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

   
    //@Autowired
    //private PasswordEncoder passwordEncoder;

   
    
    public User getUser(String login){
        
        User user = new User();
        try {
            user = User.findFirst("login=?",login);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            user=null;
        } finally {
            //Base.close();
        }
        return user;
    }
    
    public List<Map<String,Object>> getAll() {
        //Base.open(dataSource);
        List<Map<String,Object>> users = null;
        try{
            Base.openTransaction();
            users=User.findAll()
                    .include(Profile.class,Role.class)
                    .toMaps();
            Base.commitTransaction();
        }catch( Exception e){
            System.out.println("¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿");
            System.out.println(e.getMessage());
            System.out.println("¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿");
            Base.rollbackTransaction();
        }
        finally{
            //Base.close();
        }
        
        return users;
    }
    
    
    
}
