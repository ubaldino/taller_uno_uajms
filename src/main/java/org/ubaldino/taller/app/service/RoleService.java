package org.ubaldino.taller.app.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ubaldino.taller.app.dao.RoleDao;
import org.ubaldino.taller.app.model.Profile;
import org.ubaldino.taller.app.model.Role;

/**
 *
 * @author ubaldino
 */
@Service
public class RoleService{
    
    @Autowired private RoleDao roleDao;
 
    @Transactional
    public void save(Role role) {
        roleDao.save(role);
    }
 
    @Transactional
    public List<Role> list() {
        return roleDao.findAll();
    }
    
    @Transactional
    public void delete(Serializable id) {
        roleDao.deleteById(id);
    }
    
    @Transactional
    public void disable(Serializable id){
        Role role=roleDao.findById(id);
        role.setEstado((short)0);
        roleDao.save(role);
    }
    
    @Transactional
    public void enable(Serializable id){
        Role role=roleDao.findById(id);
        role.setEstado((short)1);
        roleDao.save(role);
    }

    @Transactional
    public Role getRole(Long id) {
        return roleDao.findById(id);
    }
    
}
