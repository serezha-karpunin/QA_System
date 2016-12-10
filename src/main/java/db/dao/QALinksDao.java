package db.dao;

import db.entities.QaLinksEntity;
import db.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class QALinksDao extends GenericDaoHibernateImpl<QaLinksEntity,Integer> {

    public QALinksDao() {
        super(QaLinksEntity.class);
    }

    public int countAnswers(int id_question){
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("SELECT COUNT(*) FROM QaLinksEntity WHERE idQuestion=:id_question");
        query.setParameter("id_question",id_question);
        int result = ((Long) query.uniqueResult()).intValue();
        s.close();
        return result;
    }
}


