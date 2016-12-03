package db.dao;

import db.entities.UsersEntity;
import db.util.HibernateUtil;
import org.hibernate.Session;

public class UsersDao {



    public void create(UsersEntity entity){
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(entity);
        s.getTransaction().commit();
        s.close();
    }

}
