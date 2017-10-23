package org.ubaldino.taller.app.service;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.servlet.ServletContext;
import org.javalite.activejdbc.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.ubaldino.taller.app.model.Data;
import org.ubaldino.taller.app.model.Profile;
import org.ubaldino.taller.app.model.User;

/**
 *
 * @author ubaldino
 */
@Service
public class ProfileService{
    
    @Autowired private ServletContext context;
    
    public Profile getOne(Serializable codp){
        if(!Base.hasConnection()) Base.open();
        Profile profile;
        try {
            profile=Profile.findById(codp);
        } catch (Exception e) {
            profile=null;
        }
        return profile;
    }
    
    public List<Map<String,Object>> getAll() {
        if(!Base.hasConnection()) Base.open();
        List<Map<String,Object>> profiles;
        try{
            profiles=Profile.findAll()
                    .orderBy("codp desc")
                    .include(User.class)
                    .toMaps();
        }catch( Exception e){
            System.out.println( e.getMessage() );
            profiles = null;
        }
        return profiles;
    }
    public List<Map<String,Object>> getAllSingle() {
        if(!Base.hasConnection()) Base.open();
        List<Map<String,Object>> profiles;
        try{
            profiles=Profile.findAll().orderBy("codp desc").toMaps();
        }catch( Exception e){
            System.out.println(e.getMessage());
            profiles = null;
        }
        return profiles;
    }
    
    public void disable(Serializable id){
        if(!Base.hasConnection()) Base.open();
        try{
            Base.openTransaction();
            Profile profile=Profile.findById(id);
            profile.setEstado(0);
            profile.saveIt();
            Base.commitTransaction();
        }catch( Exception e){
            System.out.println( e.getMessage() );
            Base.rollbackTransaction();
        }
        
    }
    
    public void enable(Serializable id){
        if(!Base.hasConnection()) Base.open();
        try{
            Base.openTransaction();
            Profile profile=Profile.findById(id);
            profile.setEstado(1);
            profile.saveIt();
            Base.commitTransaction();
        }catch( Exception e){
            Base.rollbackTransaction();
            System.out.println( e.getMessage() );
        }
    }
    
    public Long save(WebRequest request,MultipartFile foto) {
        if(!Base.hasConnection()) Base.open();
        System.out.println("¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿");
        String photo_name,photoLocation;
        if (foto.isEmpty())
            photo_name="user_default.png";
        else{
            photo_name=request.getParameter("nombre").replace(" ","")+"_"+foto.getOriginalFilename();
            photoLocation="public"+File.separator+"uploads"+File.separator+photo_name;
            try {
                Files.write(Paths.get(context.getRealPath(photoLocation)),foto.getBytes());
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            }
        }
        try{
            Base.openTransaction();
            Profile profile=new Profile();
            profile.setNombre(request.getParameter("nombre"));
            profile.setAp(request.getParameter("ap"));
            profile.setAm(request.getParameter("am"));
            profile.setGenero(request.getParameter("genero"));
            profile.setEstado(1);
            profile.setFnacimiento(request.getParameter("fnac"));
            profile.setEcivil(request.getParameter("ecivil"));
            profile.setTipo(request.getParameter("tipo_personal"));
            profile.setFoto(photo_name);
            profile.insert();
            if(!request.getParameter("cedula").isEmpty()) {
                System.out.println("ID>>>>> "+profile.getId());
                Data data=new Data();
                data.setProfileId((int)profile.getId());
                data.setCedula(request.getParameter("cedula"));
                data.insert();
            }
            Base.commitTransaction();
            return (Long) profile.getId();
        }catch( Exception e){
            Base.rollbackTransaction();
            System.out.println(e.getMessage());
            System.out.println("¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿");
            return Long.parseLong("0");
        }
    }
     
}
