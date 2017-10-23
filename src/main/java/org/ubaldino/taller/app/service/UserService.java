package org.ubaldino.taller.app.service;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.javalite.activejdbc.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import org.ubaldino.taller.app.model.Profile;
import org.ubaldino.taller.app.model.Role;

import org.ubaldino.taller.app.model.User;

/**
 * @author Ubaldino Zurita
 *
 */
@Service
public class UserService {
    
    @Autowired private DataSource dataSource;
    @Autowired private PasswordEncoder passwordEncoder;

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
    
    public User get(Long id){
        if(!Base.hasConnection()) Base.open();
        User user;
        try {
            user = User.findById(id);
        } catch (Exception e) {
            user=null;
        }
        return user;
    }
    
    public List<Map<String,Object>> getAll() {
        if(!Base.hasConnection()) Base.open();
        try{
            return User.findAll().include(Profile.class,Role.class).toMaps();
        }catch( Exception e){
            return null;
        }
    }
    
    public List<Map<String,Object>> getAllSingle() {
        if(!Base.hasConnection()) Base.open();
        try{
            return User.findAll().toMaps();
        }catch( Exception e){
            return null;
        }
    }
    
    public Long save(WebRequest request, Long profileId) {
        if(!Base.hasConnection()) Base.open();
        try{
            Base.openTransaction();
            Profile profile= Profile.findById(profileId);
            User user=new User();
            user.setLogin(request.getParameter("login"));
            user.setEstado(1);
            user.setPassword(
                passwordEncoder.encode(request.getParameter("password"))   
            );
            user.setProfileId((Long) profile.getId());
            user.insert();
            Base.commitTransaction();
            return (Long) user.getId();
        }
        catch( Exception e){
            Base.rollbackTransaction();
            return Long.parseLong("0");
        }
    }
    
    public boolean modify(WebRequest request, Long userId) {
        if(!Base.hasConnection()) Base.open();
        boolean state=false;
        try{
            Base.openTransaction();
            User user=User.findById(userId);
            user.setLogin(request.getParameter("login"));
            user.setPassword(
                passwordEncoder.encode(request.getParameter("password"))   
            );
            state=user.saveIt();
            Base.commitTransaction();
        }
        catch(Exception e){
            Base.rollbackTransaction();
            System.out.println(e.getMessage());
        }
        return state;
    }
    
    
}
