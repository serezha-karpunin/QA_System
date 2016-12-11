package db.dao;

import db.entities.AnswersEntity;
import db.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;


public class AnswersDao extends GenericDaoHibernateImpl<AnswersEntity,Integer> {

    public AnswersDao() {
        super(AnswersEntity.class);
    }

    public List<AnswersEntity> getAnswersByQuestionId(int question_id){
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("FROM AnswersEntity WHERE idAnswer IN (SELECT idAnswer FROM QaLinksEntity WHERE idQuestion =:question_id)");
        query.setParameter("question_id",question_id);
        List<AnswersEntity> list = query.list();
        s.close();
        return list;
    }
}
