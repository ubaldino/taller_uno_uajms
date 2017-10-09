package org.ubaldino.taller.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

/**
 *
 * @author ubaldino
 */
@Entity
@Table(name="MENUS")
public class Menu implements Serializable {

    @Id
    @Column(name="CODM")
    @GeneratedValue
    private Long codm;
    
    @Column(name="NOMBRE",nullable=false)
    @Size(min=1,max=40)
    private String nombre;
    
    @Column(name="ESTADO",insertable=false,updatable=true,nullable=false)
    @ColumnDefault("1")
    private short estado;

    public Long getCodm() {
        return codm;
    }

    public void setCodm(Long codm) {
        this.codm = codm;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }
    
}
