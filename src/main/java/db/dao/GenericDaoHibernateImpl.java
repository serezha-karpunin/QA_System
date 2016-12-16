package db.dao;

import db.util.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Created by n on 09.12.2016.
 */
public abstract class GenericDaoHibernateImpl<T, PK extends Serializable> implements GenericDao<T,PK> {

    private Class<T> type;

    public GenericDaoHibernateImpl(Class<T> type){
       this.type = type;
    }

    @Override
    public T getById(PK id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        T el = s.get(type,id);
        return el;
//        return (T) sessionFactory.getCurrentSession().get(type, id);
    }

    @Override
    public List<T> getAll() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<T> list = s.createQuery("from " + type.getName() + "").list();

        s.close();
        return list;
    }

    @Override
    public PK save(T t) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        PK id= (PK) s.save(t);
        s.getTransaction().commit();
        s.close();
        return id;
    }

    @Override
    public void update(T t) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.update(t);
        s.close();
    }

    @Override
    public void deleteById(PK id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(getById(id));
        s.getTransaction().commit();
        s.close();
    }
}
