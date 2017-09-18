package org.ubaldino.taller.app.model;

import java.io.Serializable;
import javafx.beans.DefaultProperty;
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
@Table(name="procesos")
public class Proceso implements Serializable {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name="CODP")
    private Long codp;
    
    @NotNull
    @Size(min=1,max=40)
    @Column(name="NOMBRE")
    private String nombre;
    
    @NotNull
    @Column(name="ENLACE")
    @Size(min=5,max=40)
    private String enlace;
    
    @Column(name="AYUDA",insertable=false,updatable=true,nullable=true)
    @Size(max=50)
    private String ayuda;
    
    @NotNull
    @Column(name="ESTADO",insertable = false,updatable=true)
    @ColumnDefault("1")
    private int estado;

    public Long getCodp() {
        return codp;
    }

    public void setCodp(Long codp) {
        this.codp = codp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getAyuda() {
        return ayuda;
    }

    public void setAyuda(String ayuda) {
        this.ayuda = ayuda;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
