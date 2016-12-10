package db.dao;

import db.entities.AnswersEntity;

/**
 * Created by n on 10.12.2016.
 */
public class AnswersDao extends GenericDaoHibernateImpl<AnswersEntity,Integer> {

    public AnswersDao() {
        super(AnswersEntity.class);
    }
}
