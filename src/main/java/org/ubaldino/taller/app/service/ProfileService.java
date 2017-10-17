package org.ubaldino.taller.app.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.ubaldino.taller.app.model.Profile;
import org.ubaldino.taller.app.model.Role;
import org.ubaldino.taller.app.model.User;

/**
 *
 * @author ubaldino
 */
@Service
public class ProfileService{
    
    public Profile getOne(int codp){
        Profile profile;
        try {
            profile=Profile.findById(codp);
        } catch (Exception e) {
            profile=null;
        }
        return profile;
    }
    
    public List<Map<String,Object>> getAll() {
        List<Map<String,Object>> profiles;
        try{
            profiles=Profile.findAll().include(User.class)
                    .toMaps();
        }catch( Exception e){
            profiles = null;
        }
        return profiles;
    }
    
    public void disable(int id){
        System.out.println("¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿");
        try{
            if(!Base.hasConnection()) Base.open();
            Base.openTransaction();
                Profile profile=new Profile();
                        profile=profile.findById(id);
                
                
                System.out.println( profile.toString());
                profile.setEstado(0);
                System.out.println( profile.toString());
                System.out.println( profile.saveIt());                
                
                
            Base.commitTransaction();
        }catch( Exception e){
            System.out.println( e.getMessage() );
            Base.rollbackTransaction();
        }
        System.out.println("??????????????????????????????????????  ");
    }
    
    public void enable(Serializable id){
        try{
            Base.openTransaction();
                Profile profile=Profile.findById(id);
                profile.setEstado(1);
                profile.saveIt();
            Base.commitTransaction();
        }catch( Exception e){
            Base.rollbackTransaction();
        }
    }
    /*
    
    @Transactional
    public void save(Profile profile) {
        profileDao.save(profile);
    }
    
    
    public void delete(Serializable id) {
        profileDao.deleteById(id);
    }
    

    @Transactional
    public Profile getProfile(Long id) {
        return profileDao.findById(id);
    }    
    @Transactional
    public List<Profile> list() {
       return profileDao.findAll();
    }
    */
}
