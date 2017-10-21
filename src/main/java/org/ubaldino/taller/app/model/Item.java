package org.ubaldino.taller.app.model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.IdName;
import org.javalite.activejdbc.annotations.Many2Many;
import org.javalite.activejdbc.annotations.Table;

/**
 *
 * @author ubaldino
 */


@Table("items")
@IdName("codi")
@Many2Many(other=Matter.class, join="itemat", sourceFKName="codi", targetFKName="codm")
public class Item extends Model{
    static {
        validatePresenceOf("nombre").message("Nombre must be provided");
    }
    
    public Item() {}

    public Item(String nombre){
        set("nombre",nombre);
    }
    
    public void setNombre(String nombre){
        setString("nombre", nombre);
    }
    public String getNombre(String nombre){
        return getString("nombre");
    }
    
    public void setEstado(int estado){
        setInteger("estado",estado);
    }
    public int getEstado(){
        return getInteger("estado");
    }
}
