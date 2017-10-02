package org.ubaldino.taller.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ubaldino.taller.app.dao.DataDaoInterface;
import org.ubaldino.taller.app.model.Data;

/**
 *
 * @author ubaldino
 */
@Service
public class DataService{
    @Autowired
    private DataDaoInterface dataDao;
     
    @Transactional
    public void save(Data data) {
        dataDao.save(data);
    }
    @Transactional
    public Data getData(Long id) {
        return dataDao.findById(id);
    }  
}
