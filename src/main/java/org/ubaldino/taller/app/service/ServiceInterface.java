package org.ubaldino.taller.app.service;

import java.util.List;
import java.util.Map;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author ubaldino
 * @param <T>
 */


public interface ServiceInterface<T> {
    
    T get(Long id);
    List<Map<String,Object>> getAll();
    Long save(WebRequest request, Long id) ;
    Long create(WebRequest request) ;
    boolean modify(WebRequest request, Long id);
    void disable(Long id);
    void enable(Long id);
}
