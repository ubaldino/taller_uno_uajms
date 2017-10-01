package org.ubaldino.taller.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.ubaldino.taller.app.dao.RoleDaoInterface;
import org.ubaldino.taller.app.model.Role;

/**
 *
 * @author ubaldino
 */
public class RoleService implements RoleServiceInterface {

    
    @Autowired
    private RoleDaoInterface roleDao;

    public RoleDaoInterface getRoleDao(){
        return this.roleDao;
    }

    public void setUserDao(RoleDaoInterface roleDao){
        this.roleDao = roleDao;
    }
    
     
    @Transactional
    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Transactional(readOnly=true)
    @Override
    public List<Role> list() {
        return roleDao.list();   
    }
    
}
