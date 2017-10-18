package org.ubaldino.taller.app.service;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.javalite.activejdbc.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import org.ubaldino.taller.app.model.Menu;
import org.ubaldino.taller.app.model.Role;
import org.ubaldino.taller.app.model.User;

/**
 *
 * @author ubaldino
 */
@Service
public class RoleService implements ServiceInterface<Role>{
    
    @Autowired private DataSource dataSource;
    
    @Override
    public Role get(Long id) {
        if(!Base.hasConnection()) Base.open();
        Role role;
        try {
            role = Role.findById(id);
        } catch (Exception e) {
            role=null;
        }
        return role;
    }

    @Override
    public List<Map<String, Object>> getAll() {
        if(!Base.hasConnection()) Base.open();
        try{
            return Role.findAll().include(User.class,Menu.class).toMaps();
        }catch( Exception e){
            return null;
        }
    }

    
    @Override
    public Long create(WebRequest request) {
        if(!Base.hasConnection()) Base.open();
        try{
            Base.openTransaction();
            Role role=new Role();
            role.setNombre(request.getParameter("nombre"));
            role.setEstado(1);
            role.insert();
            Base.commitTransaction();
            return (Long) role.getId();
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
            Role role=Role.findById(id);
            role.setNombre(request.getParameter("nombre"));
            state=role.saveIt();
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
            Role role=Role.findById(id);
            role.setEstado(0);
            role.saveIt();
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
            Role role=Role.findById(id);
            role.setEstado(1);
            role.saveIt();
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
