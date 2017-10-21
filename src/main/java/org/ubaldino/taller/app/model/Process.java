package org.ubaldino.taller.app.model;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.IdName;
import org.javalite.activejdbc.annotations.Many2Many;
import org.javalite.activejdbc.annotations.Table;


/**
 *
 * @author ubaldino
 */
@Table("procesos")
@IdName("codp")
@Many2Many(other=Menu.class,join="mepro",sourceFKName="codp",targetFKName="codm")
public class Process extends Model {
 
    static {
        validatePresenceOf("nombre").message("Nombre must be provided");
        validatePresenceOf("enlace").message("Nombre must be provided");
        validatePresenceOf("estado").message("Nombre must be provided");
    }
    public Process() {}

    public Process(String nombre){
        set("nombre",nombre);
    }
    
    public void setNombre(String nombre){
        setString("nombre",nombre);
    }
    public String getNombre(){
        return getString("nombre");
    }
    
    public void setEnlace(String nombre){
        setString("enlace",nombre);
    }
    public String getEnlace(){
        return getString("enlace");
    }
    
    public void setEstado(int estado){
        setInteger("estado",estado);
    }
    public int getEstado(){
        return getInteger("estado");
    }
    
}
