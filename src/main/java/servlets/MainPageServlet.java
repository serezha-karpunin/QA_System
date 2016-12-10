package servlets;

import db.dao.QuestionsDao;
import db.entities.QuestionsEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by n on 10.12.2016.
 */
@WebServlet("/main_page")
public class MainPageServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionsDao questionsDao = new QuestionsDao();
        List<QuestionsEntity> lastQuestions= questionsDao.getLastQuestions();
        List<QuestionsEntity> interestingQuestions= questionsDao.getInterestingQuestions();
        req.setAttribute("lastQuestions",lastQuestions);
        req.setAttribute("interestingQuestions",interestingQuestions);
        getServletContext().getRequestDispatcher("/jsp/public/main_page.jsp").forward(req,resp);
    }
}
