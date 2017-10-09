package org.ubaldino.taller.app.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ubaldino.taller.app.dao.MenuDao;
import org.ubaldino.taller.app.model.Menu;

/**
 *
 * @author ubaldino
 */
@Service
public class MenuService{
    
    @Autowired private MenuDao menuDao;
 
    @Transactional
    public void save(Menu menu) {
        menuDao.save(menu);
    }
 
    @Transactional
    public List<Menu> list() {
        return menuDao.findAll();
    }
    
    @Transactional
    public void delete(Serializable id) {
        menuDao.deleteById(id);
    }
    
    @Transactional
    public void disable(Serializable id){
        Menu menu=menuDao.findById(id);
        menu.setEstado((short)0);
        menuDao.save(menu);
    }
    
    @Transactional
    public void enable(Serializable id){
        Menu menu=menuDao.findById(id);
        menu.setEstado((short)1);
        menuDao.save(menu);
    }

    @Transactional
    public Menu getMenu(Long id) {
        return menuDao.findById(id);
    }
    
}