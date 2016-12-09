package db.dao;

import java.io.Serializable;

/**
 * Created by n on 09.12.2016.
 */
public interface GenericDao<T, PK extends Serializable> {

    void create(T newInstance);

    T get(PK id);

    void update(T transientObject);

    void delete(T persistentObject);

}
