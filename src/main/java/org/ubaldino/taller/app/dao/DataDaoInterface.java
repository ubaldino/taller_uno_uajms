/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ubaldino.taller.app.dao;

import org.ubaldino.taller.app.model.Data;

/**
 *
 * @author ubaldino
 */
public interface DataDaoInterface extends EntityDao<Data>  {
  
    @Override
    public void save(Data data);
    
    //User findById(Integer id);
    /*
    public List<User> findAll();
    
    public void update(User user);
    */
    //public void delete(Long codp);
    
    //public List<Data> list();
}