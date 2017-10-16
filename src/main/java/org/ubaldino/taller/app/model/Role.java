package org.ubaldino.taller.app.model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.IdName;
import org.javalite.activejdbc.annotations.Table;


/**
 *
 * @author ubaldino
 */
@Table("roles")
@IdName("codr")
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
    
    public int getEstado(){
        return getInteger("estado");
    }
   
}
