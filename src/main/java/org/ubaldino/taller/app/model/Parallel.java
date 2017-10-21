package org.ubaldino.taller.app.model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.IdName;
import org.javalite.activejdbc.annotations.Table;

/**
 *
 * @author ubaldino
 */
@Table("paralelos")
@IdName("codp")
//@Many2Many(other=Materia.class,join="mapa",sourceFKName="codp",targetFKName="codm")
public class Parallel extends Model{
    static {
        validatePresenceOf("nombre").message("Nombre must be provided");
    }
    
    public Parallel() {}

    public Parallel(String nombre){
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
