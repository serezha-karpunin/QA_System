package servlets;

import beans.AnswerListBean;
import db.dao.AnswersDao;
import db.entities.AnswersEntity;
import db.util.EntityUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/load_answers")
public class LoadAnswersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = (int) req.getServletContext().getAttribute("current_id");

        AnswersDao answersDao = new AnswersDao();
        List<AnswerListBean> answers = new ArrayList<>();
        String login = (String) req.getSession().getAttribute("userLogin");

        for (AnswersEntity ae : answersDao.getAnswersByQuestionId(id)) {
            answers.add(EntityUtil.createAnswerListBean(ae,login));
        }

        req.setAttribute("currentAnswers", answers);
        req.getRequestDispatcher("/jsp/parts/answer_list.jsp").forward(req,resp);
    }
}
