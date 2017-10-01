package org.ubaldino.taller.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.ubaldino.taller.app.dao.ProfileDaoInterface;
import org.ubaldino.taller.app.model.Profile;

/**
 *
 * @author ubaldino
 */
public class ProfileService implements ProfileServiceInterface{

    @Autowired
    private ProfileDaoInterface profileDao;
     
    @Transactional
    @Override
    public void save(Profile profile) {
        profileDao.save(profile);
    }

    @Override
    public Profile getProfile(Long id) {
        return profileDao.findById(id);
    }    
    
}
