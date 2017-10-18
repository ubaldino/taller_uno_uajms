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
public class Proceso extends Model {
 
    static {
        validatePresenceOf("nombre").message("Nombre must be provided");
        validatePresenceOf("enlace").message("Nombre must be provided");
        validatePresenceOf("estado").message("Nombre must be provided");
    }
    public Proceso() {}

    public Proceso(String nombre){
        set("nombre",nombre);
    }
    
    public String getNombre(){
        return getString("nombre");
    }
    public void setNombre(String nombre){
        setString("nombre",nombre);
    }
    
    public String getEnlace(){
        return getString("enlace");
    }
    public void setEnlace(String nombre){
        setString("enlace",nombre);
    }
    
    public int getEstado(){
        return getInteger("estado");
    }
    public void setEstado(int estado){
        setInteger("estado",estado);
    }
}
