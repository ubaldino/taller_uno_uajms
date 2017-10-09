package org.ubaldino.taller.app.model;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

/**
 *
 * @author ubaldino
 */
@Entity
@Table(name="PERSONAL")
public class Profile implements Serializable {

    @Id
    @GeneratedValue
    private Long codp;

    @NotNull
    @Column(name="NOMBRE")
    @Size(max=40,min=1)
    private String nombre;

    @Column(name="AP")
    @Size(max=40)
    private String ap;

    @Column(name="AM")
    @Size(max=40)
    private String am;

    @NotNull
    @Column(name="ESTADO",insertable=false,updatable=true)
    @ColumnDefault("1")
    private short estado;

    @NotNull
    @Column(name="FNAC")
    private Date fnac;

    @NotNull
    @Column(name="ECIVIL")
    @Size(max=1,min=1)
    private String ecivil;

    @NotNull
    @Column(name="GENERO")
    @Size(max=1,min=1)
    private String genero;

    @Column(name="DIREC")
    @Size(max=50)
    private String direc;

    @Column(name="TELF")
    @Size(max=20)
    private String telf;

    @NotNull
    @Column(name="TIPO")
    @Size(max=1,min=1)
    private String tipo;

    @Column(name="FOTO")
    @Size(max=120,min=1)
    private String foto;
    
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="codp")
    private User user;
    
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="codp")
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public Long getCodp() {
        return codp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public String getFnac() {
        return new SimpleDateFormat("yyyy-MM-dd").format(fnac);
    }

    public void setFnac(Date fnac) {
        this.fnac = fnac;
    }

    public String getEcivil() {
        return ecivil;
    }

    public void setEcivil(String ecivil) {
        this.ecivil = ecivil;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
