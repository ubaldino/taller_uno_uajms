package org.ubaldino.taller.app.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author ubaldino
 */
@Entity
@Table(name="DATOS")
public class Data implements Serializable {
    
    @Id
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="codp")
    private Profile profile;
    
    //@Id
    @Column(name="CEDULA")
    @Size(max=10,min=5)
    private String cedula;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
}