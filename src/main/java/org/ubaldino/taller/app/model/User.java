package org.ubaldino.taller.app.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;


@Entity
@Table(name="USUARIOS")
public class User implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 806778727295783363L;

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
    
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="usurol",
        joinColumns = {
            @JoinColumn(name="login", nullable = false, updatable = false)
        },
        inverseJoinColumns = {
            @JoinColumn(name = "codr", nullable = false, updatable = false) 
        }
    )
    private Set<Role> roles = new HashSet<Role>(0);

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
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
