package db.dao;

import db.entities.UsersEntity;
import db.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class UsersDao {

    public void create(UsersEntity entity) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(entity);
        s.getTransaction().commit();
        s.close();
    }

    public boolean isLoginExist(String login) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("FROM UsersEntity where login =:userLogin");
        query.setParameter("userLogin", login);
        boolean flag = query.list().size() != 0;
        s.close();
        return flag;
    }

    public boolean isEmailExist(String email) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("FROM UsersEntity where email =:userEmail");
        query.setParameter("userEmail", email);
        boolean flag = query.list().size() != 0;
        s.close();
        return flag;
    }


}
