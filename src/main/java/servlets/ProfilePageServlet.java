package servlets;

import beans.ProfileUserBean;
import beans.QuestionBean;
import db.dao.AnswersDao;
import db.dao.QuestionsDao;
import db.dao.UsersDao;
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

        UsersEntity usersEntity = usersDao.getById(visited_user);

        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT, Locale.getDefault());

        ProfileUserBean userBean = new ProfileUserBean();
        userBean.setLogin(usersEntity.getLogin());
        userBean.setRegistrationDate(df.format(usersEntity.getRegistrationDate()));
        userBean.setAnswerCount(answersDao.countAnswersByLogin(visited_user));
        userBean.setQuestionCount(questionsDao.countQuestionsByLogin(visited_user));

        List<QuestionBean> userQuestions = new ArrayList<>();

        for (QuestionsEntity entity : questionsDao.getQuestionsByLogin(visited_user)) {
            userQuestions.add(MainPageServlet.createQuestionBean(entity));
        }


//        AnswersDao answersDao = new AnswersDao();
//        List<AnswersEntity> userAnswers = answersDao.getAnswersByLogin(visited_user);
//        List<AnswersEntity> userAnswers = answersDao.getAnswersByLogin(visited_user);


        req.setAttribute("userBean", userBean);
        req.setAttribute("userQuestions", userQuestions);
//        req.setAttribute("userAnswers", );
        getServletContext().getRequestDispatcher("/jsp/public/profile_page.jsp").forward(req, resp);
    }
}
