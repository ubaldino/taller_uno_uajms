package org.ubaldino.taller.app.service;

import java.util.List;
import java.util.Map;
import org.javalite.activejdbc.Base;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import org.ubaldino.taller.app.model.Menu;
import org.ubaldino.taller.app.model.Proceso;

/**
 *
 * @author ubaldino
*/

@Service
public class ProcesoService implements ServiceInterface<Proceso>{

    @Override
    public Proceso get(Long id) {
        if(!Base.hasConnection()) Base.open();
        Proceso proceso;
        try {
            proceso = Proceso.findById(id);
        } catch (Exception e) {
            proceso=null;
        }
        return proceso;
    }

    @Override
    public List<Map<String, Object>> getAll() {
        if(!Base.hasConnection()) Base.open();
        try{
            return Proceso.findAll().include(Menu.class).toMaps();
        }catch( Exception e){
            return null;
        }
    }

    @Override
    public Long save(WebRequest request, Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long create(WebRequest request) {
        if(!Base.hasConnection()) Base.open();
        try{
            Base.openTransaction();
            Proceso proceso=new Proceso();
            proceso.setNombre(request.getParameter("nombre"));
            proceso.setEnlace(request.getParameter("enlace"));
            proceso.setEstado(1);
            proceso.insert();
            Base.commitTransaction();
            return (Long) proceso.getId();
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
            Proceso proceso=Proceso.findById(id);
            proceso.setEstado(0);
            proceso.saveIt();
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
            Proceso proceso=Proceso.findById(id);
            proceso.setEstado(1);
            proceso.saveIt();
            Base.commitTransaction();
        }catch( Exception e){
            System.out.println( e.getMessage() );
            Base.rollbackTransaction();
        }
    }
}
