package db.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {
    T getById(PK id);

    List<T> getAll();

    PK save(T entity);

    void update(T entity);

    void deleteById(PK id);
}
