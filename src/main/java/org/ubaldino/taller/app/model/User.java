package org.ubaldino.taller.app.model;

import java.io.Serializable;
import java.util.List;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;
import org.javalite.activejdbc.annotations.BelongsToParents;
import org.javalite.activejdbc.annotations.IdName;
import org.javalite.activejdbc.annotations.Many2Many;
import org.javalite.activejdbc.annotations.Table;

/**
 *
 * @author ubaldino
 */
@Table("usuarios")
@IdName("codp")
@BelongsToParents({
    @BelongsTo(parent=Profile.class,foreignKeyName="codp"),
    @BelongsTo(parent=Data.class,foreignKeyName="codp")
})
//sourceFKName=this.pk
@Many2Many(other=Role.class, join="usurol", sourceFKName="codp", targetFKName="codr")
public class User extends Model{
    
    static {
        validatePresenceOf("codp");
        validatePresenceOf("login").message("Login must be provided");
        validatePresenceOf("estado");
        validatePresenceOf("password");
    }
    
    public User(){
        if(!Base.hasConnection()) Base.open();
    }
    
    public User(String login,int estado,String password,Serializable codp){
        set("login",login,"estado",estado);
        set("password",password,"codp",codp);
    }
    
    public String getlogin(){
        return getString("login");
    }
    public void setLogin(String login){
        setString("login",login);
    }
    
    public String getPassword(){
        return getString("password");
    }

    public void setPassword(String password){
        setString("password",password);
    }
    
    public int getEstado(){
        return getInteger("estado");
    }
    public void setEstado(int estado){
        setInteger("estado",estado);
    }
    
    public Long getProfileId(){
        return getLong("codp");
    }
    public void setProfileId(Long codp){
        setLong("codp",codp);
    }
    
    public Profile getProfile(){
        return parent(Profile.class);
    }
    
    public List<Role> getRoles(){
        return getAll(Role.class); 
    }
    
}
