package servlets;

import beans.QuestionPageBean;
import db.dao.QuestionsDao;
import db.entities.QuestionsEntity;
import db.util.EntityUtil;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/question_page")
public class QuestionPageServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(QuestionPageServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        req.getServletContext().setAttribute("current_id", id);

        logger.info("QuestionPage: id = " + id);

        QuestionsDao questionsDao = new QuestionsDao();

        QuestionsEntity qe = questionsDao.getByIdWithViewsIncrement(id);
        QuestionPageBean questionBean = EntityUtil.createQuestionPageBean(qe);

        req.setAttribute("questionBean", questionBean);
        getServletContext().getRequestDispatcher("/jsp/public/question_page.jsp").forward(req, resp);
    }


}
