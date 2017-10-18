package org.ubaldino.taller.app.model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsToPolymorphic;
import org.javalite.activejdbc.annotations.Table;


/**
 *
 * @author ubaldino
 */
@Table("rolme")
@BelongsToPolymorphic(parents = {Role.class, Menu.class})
public class RolMenu extends Model {
    
}
