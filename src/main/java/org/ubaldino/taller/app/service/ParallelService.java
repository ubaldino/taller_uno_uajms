package org.ubaldino.taller.app.service;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.javalite.activejdbc.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import org.ubaldino.taller.app.model.Matter;
import org.ubaldino.taller.app.model.Parallel;

/**
 *
 * @author ubaldino
 */
@Service
public class ParallelService implements ServiceInterface<Parallel>{
    
    @Autowired private DataSource dataSource;
    
    @Override
    public Parallel get(Long id) {
        if(!Base.hasConnection()) Base.open();
        Parallel parallel;
        try {
            parallel = Parallel.findById(id);
        } catch (Exception e) {
            parallel=null;
        }
        return parallel;
    }

    @Override
    public List<Map<String, Object>> getAll() {
        if(!Base.hasConnection()) Base.open();
        try{
            return Parallel.findAll().include(Matter.class).toMaps();
        }catch( Exception e){
            return null;
        }
    }
    
    public List<Map<String,Object>> getAllSingle() {
        if(!Base.hasConnection()) Base.open();
        try{
            return Parallel.findAll().toMaps();
        }catch( Exception e){
            return null;
        }
    }

    
    @Override
    public Long create(WebRequest request) {
        if(!Base.hasConnection()) Base.open();
        try{
            Base.openTransaction();
            Parallel parallel=new Parallel();
            parallel.setNombre(request.getParameter("nombre"));
            parallel.setEstado(1);
            parallel.insert();
            Base.commitTransaction();
            return (Long) parallel.getId();
        }catch( Exception e){
            Base.rollbackTransaction();
            System.out.println(e.getMessage());
            System.out.println("¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿");
            return Long.parseLong("0");
        }
    }

    @Override
    public boolean modify(WebRequest request, Long id) {
        if(!Base.hasConnection()) Base.open();
        boolean state=false;
        try{
            Base.openTransaction();
            Parallel parallel=Parallel.findById(id);
            parallel.setNombre(request.getParameter("nombre"));
            state=parallel.saveIt();
            Base.commitTransaction();
        }
        catch(Exception e){
            Base.rollbackTransaction();
            System.out.println(e.getMessage());
        }
        return state;
    }

    @Override
    public void disable(Long id) {
        if(!Base.hasConnection()) Base.open();
        try{
            Base.openTransaction();
            Parallel parallel=Parallel.findById(id);
            parallel.setEstado(0);
            parallel.saveIt();
            Base.commitTransaction();
        }catch( Exception e){
            Base.rollbackTransaction();
            System.out.println( e.getMessage() );
        }
    }

    @Override
    public void enable(Long id) {
        if(!Base.hasConnection()) Base.open();
        try{
            Base.openTransaction();
            Parallel parallel=Parallel.findById(id);
            parallel.setEstado(1);
            parallel.saveIt();
            Base.commitTransaction();
        }catch( Exception e){
            Base.rollbackTransaction();
            System.out.println( e.getMessage() );
        }
    }

    @Override
    public Long save(WebRequest request, Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
 
}
