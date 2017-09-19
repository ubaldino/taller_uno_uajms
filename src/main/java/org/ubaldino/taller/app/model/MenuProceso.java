package org.ubaldino.taller.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ubaldino
 */
@Entity
@Table(name="MEPRO")
public class MenuProceso implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8892292964288933155L;

	@Id
    @Column(name="CODM",nullable=false)
    private Long codm;
    
    @Id
    @Column(name="CODP",nullable=false)
    private Long codp;

    public Long getCodm() {
        return codm;
    }

    public void setCodm(Long codm) {
        this.codm = codm;
    }

    public Long getCodp() {
        return codp;
    }

    public void setCodp(Long codp) {
        this.codp = codp;
    }
    
    
    
}
