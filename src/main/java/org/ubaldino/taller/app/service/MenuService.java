package org.ubaldino.taller.app.service;

import java.util.List;
import java.util.Map;
import org.javalite.activejdbc.Base;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import org.ubaldino.taller.app.model.Menu;
import org.ubaldino.taller.app.model.Proceso;
import org.ubaldino.taller.app.model.Role;

/**
 *
 * @author ubaldino
 */
@Service
public class MenuService implements ServiceInterface<Menu>{

    @Override
    public Menu get(Long id) {
        if(!Base.hasConnection()) Base.open();
        Menu menu;
        try {
            menu = Menu.findById(id);
        } catch (Exception e) {
            menu=null;
        }
        return menu;
    }

    @Override
    public List<Map<String, Object>> getAll() {
        if(!Base.hasConnection()) Base.open();
        try{
            return Menu.findAll().include(Proceso.class,Role.class).toMaps();
        }catch( Exception e){
            return null;
        }
    }

    //bananitasdev -> github
    @Override
    public Long create(WebRequest request) {
        if(!Base.hasConnection()) Base.open();
        try{
            Base.openTransaction();
            Menu menu=new Menu();
            menu.setNombre(request.getParameter("nombre"));
            menu.setEstado(1);
            menu.insert();
            Base.commitTransaction();
            return (Long) menu.getId();
        }catch( Exception e){
            Base.rollbackTransaction();
            System.out.println(e.getMessage());
            System.out.println("¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿");
            return Long.parseLong("0");
        }
    }

    @Override
    public boolean modify(WebRequest request, Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void disable(Long id) {
        if(!Base.hasConnection()) Base.open();
        try{
            Base.openTransaction();
            Menu menu=Menu.findById(id);
            menu.setEstado(0);
            menu.saveIt();
            Base.commitTransaction();
        }catch( Exception e){
            System.out.println( e.getMessage() );
            Base.rollbackTransaction();
        }
    }

    @Override
    public void enable(Long id) {
        if(!Base.hasConnection()) Base.open();
        try{
            Base.openTransaction();
            Menu menu=Menu.findById(id);
            menu.setEstado(1);
            menu.saveIt();
            Base.commitTransaction();
        }catch( Exception e){
            System.out.println( e.getMessage() );
            Base.rollbackTransaction();
        }
    }

    @Override
    public Long save(WebRequest request, Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}