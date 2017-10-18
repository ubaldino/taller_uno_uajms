package org.ubaldino.taller.app.model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.IdName;
import org.javalite.activejdbc.annotations.Many2Many;
import org.javalite.activejdbc.annotations.Table;


/**
 *
 * @author ubaldino
 */

@Table("menus")
@IdName("codm")
@Many2Many(other=Role.class, join="rolme", sourceFKName="codm", targetFKName="codr")
public class Menu extends Model {
    
    static {
        validatePresenceOf("nombre").message("Nombre must be provided");
        validatePresenceOf("estado").message("Nombre must be provided");
    }
    public Menu() {}

    public Menu(String nombre){
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
