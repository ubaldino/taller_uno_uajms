package org.ubaldino.taller.app.model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsToPolymorphic;
import org.javalite.activejdbc.annotations.Table;


/**
 *
 * @author ubaldino
 */
@Table("mepro")
@BelongsToPolymorphic(parents = {Proceso.class, Menu.class})
public class MenuProceso extends Model {
         
}
