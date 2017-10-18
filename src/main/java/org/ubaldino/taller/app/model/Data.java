package org.ubaldino.taller.app.model;

import java.io.Serializable;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;
import org.javalite.activejdbc.annotations.IdName;
import org.javalite.activejdbc.annotations.Table;


/**
 *
 * @author ubaldino
 */
@Table("datos")
@BelongsTo(parent=Profile.class,foreignKeyName="codp")
@IdName("codp")
public class Data extends Model{
        
    public void setProfileId(Serializable profile_id){
        set("codp",profile_id);
    };
    public void setCedula(String cedula){
        set("cedula",cedula);
    };
    
    
}