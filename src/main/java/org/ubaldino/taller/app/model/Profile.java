package org.ubaldino.taller.app.model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;
import org.javalite.activejdbc.annotations.IdGenerator;
import org.javalite.activejdbc.annotations.IdName;
import org.javalite.activejdbc.annotations.Table;


/**
 *
 * @author ubaldino
 */
@Table("personal")
@IdGenerator("personal_codp_seq.nextVal")
@BelongsTo(parent=User.class,foreignKeyName="codp")
@IdName("codp")
public class Profile extends Model {
     static {
        validatePresenceOf("nombre").message("must be provided");
        validatePresenceOf("ap").message("must be provided");
        validatePresenceOf("am").message("must be provided");
        validatePresenceOf("estado").message("must be provided");
        validatePresenceOf("fnac").message("must be provided");
        validatePresenceOf("ecivil").message("must be provided");
        validatePresenceOf("genero").message("must be provided");
        validatePresenceOf("direc").message("must be provided");
        validatePresenceOf("telf").message("must be provided");
        validatePresenceOf("tipo").message("must be provided");
        //validatePresenceOf("foto").message("must be provided");
        //dateFormat("MM/dd/yyyy", "fnac");
    }
    public Profile() {}

    public Profile(
            String nombre,String ap,String am,int estado,String fnac
          , String ecivil,String genero,String direc,String telf
          , String tipo,String foto 
    ){
        set("nombre",nombre);
        set("ap",ap);
        set("am",am);
        set("estado",estado);
        set("fnac",fnac);
        set("ecivil",ecivil);
        set("genero",genero);
        set("direc",direc);
        set("telf",telf);
        set("tipo",tipo);
        set("foto",foto);
    }
    

    public String getNombre(){
        return getString("nombre");
    }
    public String getAp(){
        return getString("ap");
    }
    public String getAm(){
        return getString("am");
    }
    public int getEstado(){
        return getInteger("estado");
    }
    public void setEstado(int estado){
        set("estado",estado);
    }
    
    public String getFnacimiento(){
        //setDate("dob", "1926-06-01")
        return getString("fnac");
    }
    public String getEcivil(){
        return getString("ecivil");
    }
    public String getGenero(){
        return getString("genero");
    }
    public String getDireccion(){
        return getString("direc");
    }
    public String getTelefono(){
        return getString("telf");
    }
    public String getTipo(){
        return getString("tipo");
    }
    public String getFoto(){
        return getString("foto");
    }
}
