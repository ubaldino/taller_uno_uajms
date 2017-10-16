package org.ubaldino.taller.app.model;

import java.util.List;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;
import org.javalite.activejdbc.annotations.IdName;
import org.javalite.activejdbc.annotations.Many2Many;
import org.javalite.activejdbc.annotations.Table;

@Table("usuarios")
@IdName("login")
@BelongsTo(parent = Profile.class, foreignKeyName="codp")
@Many2Many(other=Role.class, join="usurol", sourceFKName="login", targetFKName="codr")
public class User extends Model{
    
    
    static {
        validatePresenceOf("login").message("Login must be provided");
        validatePresenceOf("password","codp");
    }
    public User() {}

    public User(String login,int estado,String password,int codp){
        set("login",login,"estado",estado);
        set("password",password,"codp",codp);
    }
    
    public String getlogin(){
        return getString("login");
    }
    public String getPassword(){
        return getString("password");
    }
    
    public Profile getProfile(){
        return parent(Profile.class);
    }
    
    public List<Role> getRoles(){
        return getAll(Role.class); 
    }
    
}
