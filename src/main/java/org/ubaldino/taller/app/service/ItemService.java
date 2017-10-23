package org.ubaldino.taller.app.service;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.javalite.activejdbc.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import org.ubaldino.taller.app.model.Matter;
import org.ubaldino.taller.app.model.Item;

/**
 *
 * @author ubaldino
 */
@Service
public class ItemService implements ServiceInterface<Item>{
    
    @Autowired private DataSource dataSource;
    
    @Override
    public Item get(Long id) {
        if(!Base.hasConnection()) Base.open();
        Item item;
        try {
            item=Item.findById(id);
        } catch (Exception e) {
            item=null;
        }
        return item;
    }

    @Override
    public List<Map<String,Object>> getAll() {
        if(!Base.hasConnection()) Base.open();
        try{
            return Item.findAll().include(Matter.class).toMaps();
        }catch( Exception e){
            return null;
        }
    }
    
    public List<Map<String,Object>> getAllSingle() {
        if(!Base.hasConnection()) Base.open();
        try{
            return Item.findAll().orderBy("codi desc").toMaps();
        }catch( Exception e){
            return null;
        }
    }

    
    @Override
    public Long create(WebRequest request) {
        if(!Base.hasConnection()) Base.open();
        try{
            Base.openTransaction();
            Item item=new Item();
            item.setNombre(request.getParameter("nombre"));
            item.setEstado(1);
            item.insert();
            Base.commitTransaction();
            return (Long) item.getId();
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
            Item item=Item.findById(id);
            item.setNombre(request.getParameter("nombre"));
            state=item.saveIt();
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
            Item item=Item.findById(id);
            item.setEstado(0);
            item.saveIt();
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
            Item item=Item.findById(id);
            item.setEstado(1);
            item.saveIt();
            Base.commitTransaction();
        }catch( Exception e){
            Base.rollbackTransaction();
            System.out.println( e.getMessage() );
        }
    }

    @Override
    public Long save(WebRequest request, Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
