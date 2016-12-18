package servlets;

import beans.AnswerProfileBean;
import beans.UserProfileBean;
import beans.QuestionListBean;
import db.dao.AnswersDao;
import db.dao.QuestionsDao;
import db.dao.UsersDao;
import db.entities.AnswersEntity;
import db.entities.QuestionsEntity;
import db.entities.UsersEntity;
import db.util.EntityUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        UsersDao usersDao = new UsersDao();
        QuestionsDao questionsDao = new QuestionsDao();
        AnswersDao answersDao = new AnswersDao();

        UsersEntity usersEntity = usersDao.getById(visited_user);
        UserProfileBean userBean = EntityUtil.createUserProfileBean(usersEntity,visited_user);

        List<QuestionListBean> userQuestions = new ArrayList<>();
        for (QuestionsEntity entity : questionsDao.getQuestionsByLogin(visited_user)) {
            userQuestions.add(EntityUtil.createQuestionListBean(entity));
        }

        String login = (String) req.getSession().getAttribute("userLogin");
        List<AnswerProfileBean> userAnswers = new ArrayList<>();
        for (AnswersEntity entity : answersDao.getAnswersByLogin(visited_user)) {
            userAnswers.add(EntityUtil.createAnswerProfileBean(entity,login));
        }

        req.setAttribute("userBean", userBean);
        req.setAttribute("userQuestions", userQuestions);
        req.setAttribute("userAnswers", userAnswers);
        getServletContext().getRequestDispatcher("/jsp/public/profile_page.jsp").forward(req, resp);
    }
}
