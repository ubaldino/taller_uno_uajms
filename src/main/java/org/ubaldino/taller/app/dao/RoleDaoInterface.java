package org.ubaldino.taller.app.dao;

import java.util.List;
import org.ubaldino.taller.app.model.Role;

/**
 *
 * @author ubaldino
 */
public interface RoleDaoInterface {
    public void save(Role role);
    public List<Role> list();
}
