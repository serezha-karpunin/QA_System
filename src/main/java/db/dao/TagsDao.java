package db.dao;

import db.entities.TagsEntity;
import db.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TagsDao extends GenericDaoHibernateImpl<TagsEntity,Integer>{

    public TagsDao() {
        super(TagsEntity.class);
    }

    public List<String> getTagListByQuestionId(int question_id){
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("FROM TagsEntity WHERE idQuestion =:question_id");
        query.setParameter("question_id",question_id);
        List<TagsEntity> list = query.list();
        s.close();
        List<String> tags = new ArrayList<>();
        for (TagsEntity entity : list) {
            tags.add(entity.getTag());
        }
        ArrayList<Integer> k = new ArrayList<>();
        k.sort(Comparator.comparingInt(o -> o));
        return tags;


    }

}