package org.ubaldino.taller.app.model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsToPolymorphic;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

/**
 *
 * @author ubaldino
 */

@Table("itemat")
@BelongsToPolymorphic(parents={Matter.class,Item.class})
@CompositePK({"codm","codi"})
public class ItemMat extends Model{
    static {
        validatePresenceOf("codm").message("Nombre must be provided");
        validatePresenceOf("codi").message("Nombre must be provided");
        validatePresenceOf("gestion").message("Nombre must be provided");
    }
    
    public ItemMat() {}

    public ItemMat(Long codm,Long codi,int estado,int gestion,int ponderacion){
        set("codm",codm);
        set("codi",codi);
        set("estado",estado);
        set("gestion",gestion);
        set("ponderacion",ponderacion);
    }
    
    public void setCodM(Long codm){
        setLong("codm",codm);
    }
    public Long getCodM(){
        return getLong("codm");
    }
    
    public void setCodI(Long codi){
        setLong("codi",codi);
    }
    public Long getCodI(){
        return getLong("codi");
    }
    
    public void setEstado(int estado){
        setInteger("estado",estado);
    }
    public int getEstado(){
        return getInteger("estado");
    }
    
    public void setGestion(int gestion){
        setInteger("gestion",gestion);
    }
    public int getGestion(){
        return getInteger("gestion");
    }
    
    public void setPonderacion(int ponderacion){
        setInteger("ponderacion",ponderacion);
    }
    public int getPonderacion(){
        return getInteger("ponderacion");
    }
    
    
}
