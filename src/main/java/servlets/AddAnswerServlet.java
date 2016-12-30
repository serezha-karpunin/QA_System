package servlets;

import db.dao.AnswersDao;
import db.dao.QALinksDao;
import db.entities.AnswersEntity;
import db.entities.QaLinksEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;


@WebServlet("/add_answer")
public class AddAnswerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");
        int question_id = (int) req.getServletContext().getAttribute("current_id");
        String login = (String) req.getSession().getAttribute("userLogin");
        String text = req.getParameter("text");

        AnswersEntity ae = new AnswersEntity();
        ae.setLogin(login);
        ae.setTextAnswer(text);
        ae.setDateAnswer(new Timestamp(System.currentTimeMillis()));

        AnswersDao answersDao = new AnswersDao();
        int answer_id = answersDao.save(ae);

        QaLinksEntity qe = new QaLinksEntity();
        qe.setIdQuestion(question_id);
        qe.setIdAnswer(answer_id);

        QALinksDao qaDao = new QALinksDao();
        qaDao.save(qe);

        req.getRequestDispatcher("/load_answers").forward(req,resp);
    }
}
