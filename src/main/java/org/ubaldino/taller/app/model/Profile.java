package org.ubaldino.taller.app.model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;
import org.javalite.activejdbc.annotations.IdName;
import org.javalite.activejdbc.annotations.Table;


/**
 *
 * @author ubaldino
 */
@Table("personal")
//@IdGenerator("personal_codp_seq.nextVal")
@IdName("codp")
@BelongsTo(parent=User.class,foreignKeyName="codp")
public class Profile extends Model {
     static {
        validatePresenceOf("nombre").message("must be provided");
        //validatePresenceOf("ap").message("must be provided");
        //validatePresenceOf("am").message("must be provided");
        validatePresenceOf("estado").message("must be provided");
        validatePresenceOf("fnac").message("must be provided");
        validatePresenceOf("ecivil").message("must be provided");
        validatePresenceOf("genero").message("must be provided");
        //validatePresenceOf("direc").message("must be provided");
        //validatePresenceOf("telf").message("must be provided");
        validatePresenceOf("tipo").message("must be provided");
        //validatePresenceOf("foto").message("must be provided");
            dateFormat("yyyy-MM-dd", "fnac");
    }
    
    public Profile() {}

    public Profile(
            String nombre,String ap,String am,int estado,String fnac
          , String ecivil,String genero,String direc,String telf
          , String tipo,String foto 
    ){
        set("nombre",nombre);
        set("ap",ap);
        set("am",am);
        set("estado",estado);
        set("fnac",fnac);
        set("ecivil",ecivil);
        set("genero",genero);
        set("direc",direc);
        set("telf",telf);
        set("tipo",tipo);
        set("foto",foto);
    }
    

    public String getNombre(){
        return getString("nombre");
    }
    public void setNombre(String nombre){
        setString("nombre",nombre);
    }
    
    public String getAp(){
        return getString("ap");
    }
    public void setAp(String ap){
        setString("ap",ap);
    }
    
    public String getAm(){
        return getString("am");
    }
    public void setAm(String am){
        setString("am",am);
    }
    
    public int getEstado(){
        return getInteger("estado");
    }
    public void setEstado(int estado){
        setInteger("estado",estado);
    }
    
    public String getFnacimiento(){
        //setDate("dob", "1926-06-01")
        return getString("fnac");
    }
    public void setFnacimiento(String fnac){
        setDate("fnac",fnac);
    }
    
    public String getEcivil(){
        return getString("ecivil");
    }
    public void setEcivil(String ecivil){
        setString("ecivil",ecivil);
    }
    
    public String getGenero(){
        return getString("genero");
    }
    public void setGenero(String genero){
        setString("genero",genero);
    }
    
    public String getDireccion(){
        return getString("direc");
    }
    public void setDireccion(String direccion){
        setString("direc",direccion);
    }
    
    public String getTelefono(){
        return getString("telf");
    }
    public void setTelefono(String telf){
        setString("telf",telf);
    }
    
    public String getTipo(){
        return getString("tipo");
    }
    public void setTipo(String tipo){
        setString("tipo",tipo);
    }
    
    public String getFoto(){
        return getString("foto");
    }
    public void setFoto(String foto){
        setString("foto",foto);
    }
}
