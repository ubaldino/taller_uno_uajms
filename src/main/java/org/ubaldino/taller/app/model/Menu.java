package org.ubaldino.taller.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
    


	/**
	 * 
	 */
	private static final long serialVersionUID = -4422801687701206632L;

	@Id
    @Column(name="CODM",nullable=false)
    private Long codm;
    
    @Column(name="NOMBRE",nullable=false)
    @Size(min=1,max=40)
    private String nombre;
    
    @Column(name="ESTADO",insertable=false,updatable=true,nullable=false)
    @ColumnDefault("1")
    private int estado;

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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}