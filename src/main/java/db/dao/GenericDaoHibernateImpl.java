package db.dao;

import db.util.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;

/**
 * Created by n on 09.12.2016.
 */
public class GenericDaoHibernateImpl<T, PK extends Serializable> implements GenericDao<T,PK> {

    private Class<T> type;
    @Override
    public void create(T newInstance) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(newInstance);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public T get(PK id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        return (T) s.get(type,id);
    }

    @Override
    public void update(T transientObject) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.update(transientObject);
    }

    @Override
    public void delete(T persistentObject) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.delete(persistentObject);
    }
}
