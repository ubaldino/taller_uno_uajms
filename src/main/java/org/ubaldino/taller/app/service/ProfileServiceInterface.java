package org.ubaldino.taller.app.service;

import java.util.List;
import org.ubaldino.taller.app.model.Profile;

/**
 *
 * @author ubaldino
 */
public interface ProfileServiceInterface {

    /**
     *
     * @param profile
     */
    public void save(Profile profile);
    public Profile getProfile(Long id);
    public List<Profile> list();
}
