package org.ubaldino.taller.app.model;

import java.io.Serializable;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsToPolymorphic;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;


/**
 *
 * @author ubaldino
 */
@Table("mepro")
@BelongsToPolymorphic(parents = {Proceso.class, Menu.class})
@CompositePK({"codm","codp"})
public class MenuProceso extends Model {
    
    static {
        validatePresenceOf("codm","codp")
                .message("one or more composite PK's missing!!!");
    }
    
    public MenuProceso(){}
    
    
    public void setCodM(Serializable codm){
        setLong("codm",codm);
    }
    public void setCodP(Serializable codp){
        setLong("codp",codp);
    }
    
    public Integer getCodM(){
        return getInteger("codm");
    }
    public Integer getCodP(){
        return getInteger("codp");
    }
}
