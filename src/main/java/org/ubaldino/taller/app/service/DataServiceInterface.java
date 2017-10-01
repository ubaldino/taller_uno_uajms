package org.ubaldino.taller.app.service;

import org.ubaldino.taller.app.model.Data;

/**
 *
 * @author ubaldino
 */
public interface DataServiceInterface {
    public void save(Data data);
    public Data getData(Long id);
}
