package org.ubaldino.taller.app.dao;

/**
 *
 * @author ubaldino
 */
import java.io.Serializable;

public interface EntityDao<E> {
    E findById(Serializable id);
    void save(E entity);
}
