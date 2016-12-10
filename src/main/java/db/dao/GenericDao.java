package db.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by n on 09.12.2016.
 */
public interface GenericDao<T, PK extends Serializable> {
    T getById(PK id);

    List<T> getAll();

    void save(T entity);

    void update(T entity);

    void deleteById(PK id);
}
