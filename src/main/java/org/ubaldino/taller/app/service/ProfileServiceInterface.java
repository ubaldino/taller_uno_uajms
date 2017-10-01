package org.ubaldino.taller.app.service;

import org.ubaldino.taller.app.model.Profile;

/**
 *
 * @author ubaldino
 */
public interface ProfileServiceInterface {
    public void save(Profile user);
    public Profile getProfile(Long id);
}
