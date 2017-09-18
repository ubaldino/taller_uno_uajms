package org.ubaldino.taller.app.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    
    @Id
    @Column(name="CODR")
    @GeneratedValue
    private Long codr;
    
    @NotNull
    @Column(name="NOMBRE")
    @Size(max=10,min=3,message="{user.login.invalid}")
    private String nombre;
    
    @NotNull
    @Column(name="ESTADO",insertable=false,updatable=true)
    @ColumnDefault("1")
    private int estado;
    
   
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
