package org.ubaldino.taller.app.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ubaldino.taller.app.dao.ProfileDao;
import org.ubaldino.taller.app.model.Profile;

/**
 *
 * @author ubaldino
 */
@Service
public class ProfileService{

    @Autowired
    private ProfileDao profileDao;
     
    @Transactional
    public void save(Profile profile) {
        profileDao.save(profile);
    }
    
    @Transactional
    public void delete(Serializable id) {
        profileDao.deleteById(id);
    }
    
    @Transactional
    public void disable(Serializable id){
        Profile profile=profileDao.findById(id);
        profile.setEstado((short)0);
        profileDao.save(profile);
    }
    
    @Transactional
    public void enable(Serializable id){
        Profile profile=profileDao.findById(id);
        profile.setEstado((short)1);
        profileDao.save(profile);
    }

    @Transactional
    public Profile getProfile(Long id) {
        return profileDao.findById(id);
    }    
    @Transactional
    public List<Profile> list() {
       return profileDao.findAll();
    }
    
}
