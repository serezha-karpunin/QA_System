package db.dao;

import db.entities.LikesEntity;
import db.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class LikesDao extends GenericDaoHibernateImpl<LikesEntity,Integer> {

    public LikesDao() {
        super(LikesEntity.class);
    }

    public int countLikes(int id_answer){
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("SELECT COUNT(*) FROM LikesEntity WHERE idAnswer=:id_answer");
        query.setParameter("id_answer",id_answer);
        int result = ((Long) query.uniqueResult()).intValue();
        s.close();
        return result;
    }

    public boolean isLiked (int id_answer, String login){
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("SELECT COUNT(*) FROM LikesEntity WHERE idAnswer=:id_answer AND login=:login");
        query.setParameter("id_answer",id_answer);
        query.setParameter("login",login);
        int result = ((Long) query.uniqueResult()).intValue();
        s.close();
        return result!=0;
    }

}