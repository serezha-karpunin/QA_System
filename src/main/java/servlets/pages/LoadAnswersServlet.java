package servlets.pages;

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
        resp.sendRedirect("/jsp/public/error_page.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object current_id = req.getServletContext().getAttribute("current_id");

        if (current_id == null) {
            resp.sendRedirect("/jsp/public/error_page.jsp");
            return;
        }

        int id = (int) current_id;

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
