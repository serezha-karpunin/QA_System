package db.dao;

import db.entities.AnswersEntity;
import db.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;


public class AnswersDao extends GenericDaoHibernateImpl<AnswersEntity, Integer> {

    public AnswersDao() {
        super(AnswersEntity.class);
    }

    public List<AnswersEntity> getAnswersByQuestionId(int question_id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("FROM AnswersEntity WHERE idAnswer IN (SELECT idAnswer FROM QaLinksEntity WHERE idQuestion =:question_id)");
        query.setParameter("question_id", question_id);
        List<AnswersEntity> list = query.list();
        s.close();
        return list;
    }

    public List<AnswersEntity> getAnswersByLogin(String login) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("FROM AnswersEntity WHERE login =:login");
        query.setParameter("login", login);
        List<AnswersEntity> result = query.list();
        s.close();
        return result;
    }

    public int countAnswersByLogin(String login) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("SELECT COUNT(*) FROM AnswersEntity WHERE login=:login");
        query.setParameter("login", login);
        int result = ((Long) query.uniqueResult()).intValue();
        s.close();
        return result;
    }
}
