package org.ubaldino.taller.app.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;

/**
 *
 * @author ubaldino
 */

@Entity
@Table(name="ROLES")
public class Role implements Serializable {
    
    /**
    * 
    */
    private static final long serialVersionUID = -1109080371998017560L;

    @Id
    @Column(name="CODR")
    @GeneratedValue
    private Long codr;
    
    @NotNull
    @Column(name="NOMBRE")
    @Size(max=24,min=3,message="{user.login.invalid}")
    private String nombre;
    
    @NotNull
    @Column(name="ESTADO",insertable=false,updatable=true)
    @ColumnDefault("1")
    private int estado;
    
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="usurol",
        joinColumns = {
            @JoinColumn(name="codr", nullable = false, updatable = false)
        },
        inverseJoinColumns = {
            @JoinColumn(name="login", nullable = false, updatable = false)
        }
    )
    private Set<User> users = new HashSet<User>(0);

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
    
   
    public Long getCodr() {
        return codr;
    }

    public void setCodr(Long codr) {
        this.codr = codr;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
