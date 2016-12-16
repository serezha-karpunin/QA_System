package servlets;

import beans.AnswerBean;
import db.dao.AnswersDao;
import db.dao.LikesDao;
import db.entities.AnswersEntity;

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
        LikesDao likesDao = new LikesDao();

        List<AnswerBean> answers = new ArrayList<>();

        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT, Locale.getDefault());


        for (AnswersEntity ae : answersDao.getAnswersByQuestionId(id)) {
            AnswerBean answerBean = new AnswerBean();
            answerBean.setIdAnswer(ae.getIdAnswer());
            answerBean.setLogin(ae.getLogin());
            answerBean.setTextAnswer(ae.getTextAnswer());
            answerBean.setDate(df.format(ae.getDateAnswer()));
            answerBean.setLikes(likesDao.countLikes(ae.getIdAnswer()));

            String login = (String) req.getSession().getAttribute("userLogin");
            answerBean.setLikedByCurrentUser((login != null) && likesDao.isLiked(ae.getIdAnswer(), login));

            answers.add(answerBean);
        }

        req.setAttribute("currentAnswers", answers);

        req.getRequestDispatcher("/jsp/parts/answer_list.jsp").forward(req,resp);
    }
}
