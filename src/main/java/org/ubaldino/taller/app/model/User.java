package org.ubaldino.taller.app.model;

import java.io.Serializable;
import java.sql.SQLException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;


@Entity
@Table(name="USUARIOS")
public class User implements Serializable {

    
    @Id
    @Column(name="LOGIN")
    @Size(max=10,min=3,message="{user.login.invalid}")
    private String login;

    @NotNull
    @Column(name="PASSWORD" )
    @Size(min=3,message="{user.password.invalid}")
    private String password;

    
    @NotNull
    @Column(name="ESTADO",insertable=false,updatable=true)
    @ColumnDefault("1")
    private int estado;
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
