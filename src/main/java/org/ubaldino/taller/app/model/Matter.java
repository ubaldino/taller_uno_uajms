package org.ubaldino.taller.app.model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.IdName;
import org.javalite.activejdbc.annotations.Many2Many;
import org.javalite.activejdbc.annotations.Table;

/**
 *
 * @author ubaldino
 */
@Table("materias")
@IdName("codm")
@Many2Many(other=Item.class, join="itemat", sourceFKName="codm", targetFKName="codi")
public class Matter extends Model{
    static {
        validatePresenceOf("codigo").message("Nombre must be provided");
        validatePresenceOf("nombre").message("Nombre must be provided");
    }
    
    public Matter() {}

    public Matter(String nombre,String codigo){
        set("codigo",codigo);
        set("nombre",nombre);
    }
    
    public void setCodigo(String codigo){
        setString("codigo",codigo);
    }
    public String getCodigo(String codigo){
        return getString("codigo");
    }
    
    public void setNombre(String nombre){
        setString("nombre",nombre);
    }
    public String getNombre(){
        return getString("nombre");
    }
    
    public void setEstado(int estado){
        setInteger("estado",estado);
    }
    public int getEstado(){
        return getInteger("estado");
    }
    
}
