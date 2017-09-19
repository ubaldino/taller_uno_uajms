package org.ubaldino.taller.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ubaldino
 */
@Entity
@Table(name="ROLME")
public class RolMenu implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 5971708711302242650L;

	@Id
    @NotNull
    @Column(name="CODR")
    private Long codr;
    
    @Id
    @NotNull
    @Column(name="CODM")
    private Long codm;

    public Long getCodr() {
        return codr;
    }

    public void setCodr(Long codr) {
        this.codr = codr;
    }

    public Long getCodm() {
        return codm;
    }

    public void setCodm(Long codm) {
        this.codm = codm;
    }

    
}
