package org.ubaldino.taller.app.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
  * @author ubaldino
*/
@Entity
@Table(name="USUROL")
public class UserRol implements Serializable {

    @NotNull
    @Column(name="CODR")
    @Id
    private Long codr;
    
    @NotNull
    @Column(name="LOGIN")
    @Size(max=10,min=3,message="{user.login.invalid}")
    private String login;

    public Long getCodr() {
        return codr;
    }

    public void setCodr(Long codr) {
        this.codr = codr;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}