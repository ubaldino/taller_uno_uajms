package org.ubaldino.taller.app.dao;

import org.ubaldino.taller.app.model.Profile;

/**
 *
 * @author ubaldino
 */
public interface ProfileDaoInterface extends EntityDao<Profile>{ 
    @Override
    public void save(Profile profile);
}
