package servlets;

import beans.QuestionBean;
import db.dao.QALinksDao;
import db.dao.QuestionsDao;
import db.dao.TagsDao;
import db.entities.QuestionsEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by n on 10.12.2016.
 */
@WebServlet("/main_page")
public class MainPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionsDao questionsDao = new QuestionsDao();
        TagsDao tagsDao = new TagsDao();
        QALinksDao qaDao = new QALinksDao();

        List<QuestionBean> lastQuestions = new ArrayList<>();

        List<QuestionsEntity> lastQuestionEntities = questionsDao.getLastQuestions();

        for (QuestionsEntity entity : lastQuestionEntities) {
            QuestionBean bean = new QuestionBean();
            bean.setIdQuestion(entity.getIdQuestion());
            bean.setTitle(entity.getTitle());
            bean.setLogin(entity.getLogin());
            bean.setDate(entity.getDate());
            bean.setViews(entity.getViews());
            bean.setTags(tagsDao.getTagListByQuestionId(entity.getIdQuestion()));
            bean.setAnswers(qaDao.countAnswers(entity.getIdQuestion()));
            lastQuestions.add(bean);
        }


//        List<QuestionsEntity> lastQuestions= questionsDao.getLastQuestions();
//        List<QuestionsEntity> interestingQuestions = questionsDao.getInterestingQuestions();
        req.setAttribute("lastQuestions", lastQuestions);
//        req.setAttribute("interestingQuestions", interestingQuestions);
        getServletContext().getRequestDispatcher("/jsp/public/main_page.jsp").forward(req, resp);
    }
}
