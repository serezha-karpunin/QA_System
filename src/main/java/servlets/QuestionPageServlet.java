package servlets;

import beans.AnswerBean;
import beans.QuestionPageBean;
import db.dao.*;
import db.entities.AnswersEntity;
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


@WebServlet("/question_page")
public class QuestionPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        QuestionsDao questionsDao = new QuestionsDao();
        AnswersDao answersDao = new AnswersDao();
        TagsDao tagsDao = new TagsDao();
        LikesDao likesDao = new LikesDao();

        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT, Locale.getDefault());

        QuestionsEntity qe = questionsDao.getById(id);
        QuestionPageBean questionBean = new QuestionPageBean();

        questionBean.setIdQuestion(qe.getIdQuestion());
        questionBean.setTitle(qe.getTitle());
        questionBean.setText(qe.getText());
        questionBean.setLogin(qe.getLogin());
        questionBean.setDate(df.format(qe.getDate()));
        questionBean.setViews(qe.getViews());
        questionBean.setTags(tagsDao.getTagListByQuestionId(qe.getIdQuestion()));

        List<AnswerBean> answers = new ArrayList<>();

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

        questionBean.setAnswers(answers);

        System.out.println(questionBean.toString());

        req.setAttribute("questionBean", questionBean);
        getServletContext().getRequestDispatcher("/jsp/public/question_page.jsp").forward(req, resp);
    }


}
