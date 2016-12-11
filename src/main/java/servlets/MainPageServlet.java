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
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by n on 10.12.2016.
 */
@WebServlet("/main_page")
public class MainPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionsDao questionsDao = new QuestionsDao();

        List<QuestionBean> lastQuestions = new ArrayList<>();
        List<QuestionsEntity> lastQuestionEntities = questionsDao.getLastQuestions();

        for (QuestionsEntity entity : lastQuestionEntities) {
            lastQuestions.add(createQuestionBean(entity));
        }

        List<QuestionBean> interestingQuestions = new ArrayList<>();
        List<QuestionsEntity> interestingQuestionEntities = questionsDao.getInterestingQuestions();

        for (QuestionsEntity entity : interestingQuestionEntities) {
            interestingQuestions.add(createQuestionBean(entity));
        }

        req.setAttribute("lastQuestions", lastQuestions);
        req.setAttribute("interestingQuestions", interestingQuestions);
        getServletContext().getRequestDispatcher("/jsp/public/main_page.jsp").forward(req, resp);
    }

    private QuestionBean createQuestionBean(QuestionsEntity entity){
        TagsDao tagsDao = new TagsDao();
        QALinksDao qaDao = new QALinksDao();

        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT, Locale.getDefault());

        QuestionBean bean = new QuestionBean();
        bean.setIdQuestion(entity.getIdQuestion());
        bean.setTitle(entity.getTitle());
        bean.setLogin(entity.getLogin());
        bean.setDate(df.format(entity.getDate()));
        bean.setViews(entity.getViews());
        bean.setTags(tagsDao.getTagListByQuestionId(entity.getIdQuestion()));
        bean.setAnswers(qaDao.countAnswers(entity.getIdQuestion()));

        return bean;
    }
}
