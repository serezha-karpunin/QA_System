package servlets;

import beans.ProfileAnswerBean;
import beans.ProfileUserBean;
import beans.QuestionBean;
import db.dao.AnswersDao;
import db.dao.LikesDao;
import db.dao.QuestionsDao;
import db.dao.UsersDao;
import db.entities.AnswersEntity;
import db.entities.QuestionsEntity;
import db.entities.UsersEntity;

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

@WebServlet("/user_profile")
public class ProfilePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String visited_user = req.getParameter("visitedUser");
        if (visited_user == null) resp.sendRedirect("/");

//        String current_user = (String) req.getSession().getAttribute("userLogin");

        UsersDao usersDao = new UsersDao();
        QuestionsDao questionsDao = new QuestionsDao();
        AnswersDao answersDao = new AnswersDao();
        LikesDao likesDao = new LikesDao();

        UsersEntity usersEntity = usersDao.getById(visited_user);

        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());

        ProfileUserBean userBean = new ProfileUserBean();
        userBean.setLogin(usersEntity.getLogin());
        userBean.setRegistrationDate(df.format(usersEntity.getRegistrationDate()));
        userBean.setAnswerCount(answersDao.countAnswersByLogin(visited_user));
        userBean.setQuestionCount(questionsDao.countQuestionsByLogin(visited_user));

        List<QuestionBean> userQuestions = new ArrayList<>();

        for (QuestionsEntity entity : questionsDao.getQuestionsByLogin(visited_user)) {
            userQuestions.add(MainPageServlet.createQuestionBean(entity));
        }

        List<ProfileAnswerBean> userAnswers = new ArrayList<>();
        System.out.println("before");
        for (AnswersEntity entity : answersDao.getAnswersByLogin(visited_user)) {
            ProfileAnswerBean bean = new ProfileAnswerBean();

            bean.setIdAnswer(entity.getIdAnswer());
            bean.setLogin(entity.getLogin());
            bean.setTextAnswer(entity.getTextAnswer());
            bean.setDate(df.format(entity.getDateAnswer()));
            bean.setLikes(likesDao.countLikes(entity.getIdAnswer()));

            String login = (String) req.getSession().getAttribute("userLogin");
            bean.setIsLikedByCurrentUser((login != null) && likesDao.isLiked(entity.getIdAnswer(), login));
            System.out.println("id answer "+ entity.getIdAnswer());
            QuestionsEntity qe = questionsDao.getQuestionByAnswer(entity.getIdAnswer());
            if(qe==null) System.out.println("alalalla");
            bean.setIdQuestion(qe.getIdQuestion());
            bean.setTitle(qe.getTitle());

            userAnswers.add(bean);
        }


        req.setAttribute("userBean", userBean);
        req.setAttribute("userQuestions", userQuestions);
        req.setAttribute("userAnswers", userAnswers);
        System.out.println("all gogogog");
        getServletContext().getRequestDispatcher("/jsp/public/profile_page.jsp").forward(req, resp);
    }
}
