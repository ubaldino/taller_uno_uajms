package org.ubaldino.taller.app.service;

import java.util.List;
import org.ubaldino.taller.app.model.Role;

/**
 *
 * @author ubaldino
 */
public interface RoleServiceInterface {
    public void save(Role role);
    public List<Role> list();
}

