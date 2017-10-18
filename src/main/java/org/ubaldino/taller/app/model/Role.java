package org.ubaldino.taller.app.model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.IdName;
import org.javalite.activejdbc.annotations.Many2Many;
import org.javalite.activejdbc.annotations.Table;


/**
 *
 * @author ubaldino
 */
@Table("roles")
@IdName("codr")

@Many2Many(other=User.class, join="usurol", sourceFKName="codr", targetFKName="codp")
public class Role extends Model {
    
    static {
        validatePresenceOf("nombre").message("Nombre must be provided");
    }
    public Role() {}

    public Role(String nombre){
        set("nombre",nombre);
    }
    
    public String getNombre(){
        return getString("nombre");
    }
    public void setNombre(String nombre){
        setString("nombre",nombre);
    }
    
    public int getEstado(){
        return getInteger("estado");
    }
    public void setEstado(int estado){
        setInteger("estado",estado);
    }
   
}
