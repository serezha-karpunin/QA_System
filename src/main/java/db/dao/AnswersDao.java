package db.dao;

import db.entities.AnswersEntity;


public class AnswersDao extends GenericDaoHibernateImpl<AnswersEntity,Integer> {

    public AnswersDao() {
        super(AnswersEntity.class);
    }

}
