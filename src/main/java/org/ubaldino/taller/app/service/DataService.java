package org.ubaldino.taller.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.ubaldino.taller.app.dao.DataDaoInterface;
import org.ubaldino.taller.app.model.Data;

/**
 *
 * @author ubaldino
 */
public class DataService implements DataServiceInterface{
    @Autowired
    private DataDaoInterface dataDao;
     
    @Transactional
    @Override
    public void save(Data data) {
        dataDao.save(data);
    }

    @Override
    public Data getData(Long id) {
        return dataDao.findById(id);
    }  
}
