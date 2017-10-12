package org.ubaldino.taller.app.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ubaldino.taller.app.dao.ProcesoDao;
import org.ubaldino.taller.app.model.Proceso;

/**
 *
 * @author ubaldino
 */
@Service
public class ProcesoService {
    @Autowired private ProcesoDao procesoDao;
 
    @Transactional
    public void save(Proceso proceso) {
        procesoDao.save(proceso);
    }
 
    @Transactional
    public List<Proceso> list() {
        return procesoDao.findAll();
    }
    
    @Transactional
    public void delete(Serializable id) {
        procesoDao.deleteById(id);
    }
    
    @Transactional
    public void disable(Serializable id){
        Proceso proceso=procesoDao.findById(id);
        proceso.setEstado((short)0);
        procesoDao.save(proceso);
    }
    
    @Transactional
    public void enable(Serializable id){
        Proceso proceso=procesoDao.findById(id);
        proceso.setEstado((short)1);
        procesoDao.save(proceso);
    }

    @Transactional
    public Proceso getProceso(Long id) {
        return procesoDao.findById(id);
    }
}
