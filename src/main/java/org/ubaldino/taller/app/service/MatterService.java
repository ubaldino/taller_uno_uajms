package org.ubaldino.taller.app.service;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.javalite.activejdbc.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import org.ubaldino.taller.app.model.Item;
import org.ubaldino.taller.app.model.Matter;
import org.ubaldino.taller.app.model.Parallel;

/**
 *
 * @author ubaldino
 */
@Service
public class MatterService implements ServiceInterface<Matter>{
    
    @Autowired private DataSource dataSource;
    
    @Override
    public Matter get(Long id) {
        if(!Base.hasConnection()) Base.open();
        Matter matter;
        try {
            matter = Matter.findById(id);
        } catch (Exception e) {
            matter=null;
        }
        return matter;
    }

    @Override
    public List<Map<String, Object>> getAll() {
        if(!Base.hasConnection()) Base.open();
        try{
            return Matter.findAll().include(Parallel.class,Item.class).toMaps();
        }catch( Exception e){
            return null;
        }
    }
    
    public List<Map<String,Object>> getAllSingle() {
        if(!Base.hasConnection()) Base.open();
        try{
            return Matter.findAll().toMaps();
        }catch( Exception e){
            return null;
        }
    }

    
    @Override
    public Long create(WebRequest request) {
        if(!Base.hasConnection()) Base.open();
        try{
            Base.openTransaction();
            Matter matter=new Matter();
            matter.setNombre(request.getParameter("nombre"));
            matter.setEstado(1);
            matter.insert();
            Base.commitTransaction();
            return (Long) matter.getId();
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
            Matter matter=Matter.findById(id);
            matter.setNombre(request.getParameter("nombre"));
            state=matter.saveIt();
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
            Matter matter=Matter.findById(id);
            matter.setEstado(0);
            matter.saveIt();
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
            Matter matter=Matter.findById(id);
            matter.setEstado(1);
            matter.saveIt();
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
