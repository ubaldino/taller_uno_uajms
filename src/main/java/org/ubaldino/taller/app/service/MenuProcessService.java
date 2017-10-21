/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ubaldino.taller.app.service;

import java.io.Serializable;
import org.javalite.activejdbc.Base;
import org.springframework.stereotype.Service;
import org.ubaldino.taller.app.model.MenuProcess;

/**
 *
 * @author ubaldino
 */
@Service
public class MenuProcessService {
    
    
    public Long create(Serializable codm,Serializable codp){
        if(!Base.hasConnection()) Base.open();
        try{
            Base.openTransaction();
            MenuProcess menuProceso=new MenuProcess();
            menuProceso.setCodM(codm);
            menuProceso.setCodP(codp);
            menuProceso.insert();
            Base.commitTransaction();
            return (Long) menuProceso.getId();
        }
        catch( Exception e){
            Base.rollbackTransaction();
            System.out.println( e.getMessage() );
            return Long.parseLong("0");
        }
        
    }
    
    public boolean delete(Serializable codm,Serializable codp){
        if(!Base.hasConnection()) Base.open();
        boolean state=false;
        try{    
            Base.openTransaction();
            MenuProcess menuProceso=new MenuProcess();
            menuProceso.setCodM(codm);
            menuProceso.setCodP(codp);
            menuProceso.delete();
            Base.commitTransaction();
            state=true;
        }
        catch( Exception e){
            Base.rollbackTransaction();
            System.out.println( e.getMessage() );
        }
        return state;
        
    }
}
