package db.dao;

import db.entities.QuestionsEntity;
import db.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;


public class QuestionsDao extends GenericDaoHibernateImpl<QuestionsEntity,Integer>{

    public QuestionsDao() {
        super(QuestionsEntity.class);
    }
    public List<QuestionsEntity> getInterestingQuestions(){
        List<QuestionsEntity> list = getAll();
        list.sort((o1,o2)->o2.getViews() - o1.getViews());
        return list;
    }
    public List<QuestionsEntity> getLastQuestions(){
        List<QuestionsEntity> list = getAll();
        list.sort((o1, o2) -> o2.getIdQuestion() - o1.getIdQuestion());
        return list;
    }
    public List<QuestionsEntity> getQuestionsByLogin(String login){
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("FROM QuestionsEntity WHERE login =:login");
        query.setParameter("login",login);
        List<QuestionsEntity> list = query.list();
        s.close();
        return list;
    }

    public QuestionsEntity getByIdWithViewsIncrement(int id){
        QuestionsEntity qe = getById(id);
        qe.setViews(qe.getViews()+1);
        update(qe);
        return qe;
    }

    public int countQuestionsByLogin(String login) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("SELECT COUNT(*) FROM QuestionsEntity WHERE login=:login");
        query.setParameter("login", login);
        int result = ((Long) query.uniqueResult()).intValue();
        s.close();
        return result;
    }

    public QuestionsEntity getQuestionByAnswer(int answer_id){
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("FROM QuestionsEntity WHERE idQuestion IN(SELECT idQuestion FROM QaLinksEntity WHERE idAnswer=:answer_id)");
        query.setParameter("answer_id", answer_id);
        QuestionsEntity result =(QuestionsEntity)query.uniqueResult();
        s.close();
        return result;
    }

    public List<QuestionsEntity> getQuestionsByTag(String tag){
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("FROM QuestionsEntity WHERE idQuestion IN(SELECT idQuestion FROM TagsEntity WHERE tag=:tag)");
        query.setParameter("tag",tag);
        List<QuestionsEntity> list = query.list();
        s.close();
        return list;
    }
}
