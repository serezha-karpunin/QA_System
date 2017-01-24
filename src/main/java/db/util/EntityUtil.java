package db.util;

import beans.*;
import db.dao.*;
import db.entities.AnswersEntity;
import db.entities.QuestionsEntity;
import db.entities.UsersEntity;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class EntityUtil {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm dd.MM.yyyy",Locale.getDefault());

    public static QuestionListBean createQuestionListBean(QuestionsEntity entity){
        TagsDao tagsDao = new TagsDao();
        QALinksDao qaDao = new QALinksDao();

        QuestionListBean bean = new QuestionListBean();
        bean.setIdQuestion(entity.getIdQuestion());
        bean.setTitle(entity.getTitle());
        bean.setLogin(entity.getLogin());
        bean.setDate(simpleDateFormat.format(entity.getDateQuestion()));
        bean.setViews(entity.getViews());
        bean.setTags(tagsDao.getTagListByQuestionId(entity.getIdQuestion()));
        bean.setAnswers(qaDao.countAnswers(entity.getIdQuestion()));

        return bean;
    }

    public static QuestionPageBean createQuestionPageBean(QuestionsEntity qe){
        TagsDao tagsDao = new TagsDao();
        UsersDao usersDao = new UsersDao();
        QuestionPageBean questionBean = new QuestionPageBean();
        questionBean.setIdQuestion(qe.getIdQuestion());
        questionBean.setTitle(qe.getTitle());
        questionBean.setText(qe.getTextQuestion());
        questionBean.setLogin(qe.getLogin());
        questionBean.setDate(simpleDateFormat.format(qe.getDateQuestion()));
        questionBean.setViews(qe.getViews());
        questionBean.setTags(tagsDao.getTagListByQuestionId(qe.getIdQuestion()));
        questionBean.setUserImage(usersDao.getById(qe.getLogin()).getImageLink());
        return questionBean;
    }

    public static AnswerListBean createAnswerListBean(AnswersEntity ae, String login){
        LikesDao likesDao = new LikesDao();
        UsersDao usersDao = new UsersDao();
        AnswerListBean answerBean = new AnswerListBean();
        answerBean.setIdAnswer(ae.getIdAnswer());
        answerBean.setLogin(ae.getLogin());
        answerBean.setTextAnswer(ae.getTextAnswer());
        answerBean.setDate(simpleDateFormat.format(ae.getDateAnswer()));
        answerBean.setLikes(likesDao.countLikes(ae.getIdAnswer()));
        answerBean.setIsLikedByCurrentUser((login != null) && likesDao.isLiked(ae.getIdAnswer(), login));
        answerBean.setUserImage(usersDao.getById(ae.getLogin()).getImageLink());
        return answerBean;
    }

    public static AnswerProfileBean createAnswerProfileBean(AnswersEntity entity, String login){
        LikesDao likesDao = new LikesDao();
        QuestionsDao questionsDao = new QuestionsDao();
        UsersDao usersDao = new UsersDao();
        AnswerProfileBean bean = new AnswerProfileBean();
        bean.setIdAnswer(entity.getIdAnswer());
        bean.setLogin(entity.getLogin());
        bean.setTextAnswer(entity.getTextAnswer());
        bean.setDate(simpleDateFormat.format(entity.getDateAnswer()));
        bean.setLikes(likesDao.countLikes(entity.getIdAnswer()));
        bean.setUserImage(usersDao.getById(entity.getLogin()).getImageLink());

        bean.setIsLikedByCurrentUser((login != null) && likesDao.isLiked(entity.getIdAnswer(), login));
        QuestionsEntity qe = questionsDao.getQuestionByAnswer(entity.getIdAnswer());
        bean.setIdQuestion(qe.getIdQuestion());
        bean.setTitle(qe.getTitle());

        return bean;
    }

    public static UserProfileBean createUserProfileBean(UsersEntity usersEntity, String visited_user){
        QuestionsDao questionsDao = new QuestionsDao();
        AnswersDao answersDao = new AnswersDao();
        UsersDao usersDao = new UsersDao();

        UserProfileBean userBean = new UserProfileBean();
        userBean.setLogin(usersEntity.getLogin());
        userBean.setRegistrationDate(simpleDateFormat.format(usersEntity.getRegistrationDate()));
        userBean.setAnswerCount(answersDao.countAnswersByLogin(visited_user));
        userBean.setQuestionCount(questionsDao.countQuestionsByLogin(visited_user));
        userBean.setUserImage(usersDao.getById(visited_user).getImageLink());
        return userBean;
    }

    public static UserSettingsBean createUserSettingsBean(UsersEntity usersEntity){
        QuestionsDao questionsDao = new QuestionsDao();
        AnswersDao answersDao = new AnswersDao();

        UserSettingsBean userBean = new UserSettingsBean();
        userBean.setLogin(usersEntity.getLogin());
        userBean.setEmail(usersEntity.getEmail());
        userBean.setPassword(usersEntity.getPassword());
        userBean.setRegistrationDate(simpleDateFormat.format(usersEntity.getRegistrationDate()));
        userBean.setAnswerCount(answersDao.countAnswersByLogin(usersEntity.getLogin()));
        userBean.setQuestionCount(questionsDao.countQuestionsByLogin(usersEntity.getLogin()));
        userBean.setLang(usersEntity.getLang());
        userBean.setUserImage(usersEntity.getImageLink());
        return userBean;
    }

}
