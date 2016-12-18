package servlets;

import beans.QuestionPageBean;
import db.dao.QuestionsDao;
import db.dao.TagsDao;
import db.entities.QuestionsEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;


@WebServlet("/question_page")
public class QuestionPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        req.getServletContext().setAttribute("current_id", id);

        QuestionsDao questionsDao = new QuestionsDao();
        TagsDao tagsDao = new TagsDao();

        //DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT, Locale.getDefault());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm dd.MM.yyyy",Locale.getDefault());
        QuestionsEntity qe = questionsDao.getByIdWithViewsIncrement(id);


        QuestionPageBean questionBean = new QuestionPageBean();

        questionBean.setIdQuestion(qe.getIdQuestion());
        questionBean.setTitle(qe.getTitle());
        questionBean.setText(qe.getText());
        questionBean.setLogin(qe.getLogin());
        questionBean.setDate(simpleDateFormat.format(qe.getDate()));
        questionBean.setViews(qe.getViews());
        questionBean.setTags(tagsDao.getTagListByQuestionId(qe.getIdQuestion()));


//        questionBean.setAnswers(answers);


        req.setAttribute("questionBean", questionBean);
        getServletContext().getRequestDispatcher("/jsp/public/question_page.jsp").forward(req, resp);
    }


}
