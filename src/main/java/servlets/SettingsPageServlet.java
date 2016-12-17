package servlets;

import beans.SettingsUserBean;
import db.dao.AnswersDao;
import db.dao.QuestionsDao;
import db.dao.UsersDao;
import db.entities.UsersEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Locale;

@WebServlet("/user_settings")
public class SettingsPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("userLogin");
        if(login == null) resp.sendRedirect("/");

        UsersDao usersDao = new UsersDao();
        QuestionsDao questionsDao = new QuestionsDao();
        AnswersDao answersDao = new AnswersDao();

        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());

        UsersEntity usersEntity = usersDao.getById(login);
        SettingsUserBean userBean = new SettingsUserBean();

        userBean.setLogin(usersEntity.getLogin());
        userBean.setEmail(usersEntity.getEmail());
        userBean.setPassword(usersEntity.getPassword());
        userBean.setRegistrationDate(df.format(usersEntity.getRegistrationDate()));
        userBean.setAnswerCount(answersDao.countAnswersByLogin(login));
        userBean.setQuestionCount(questionsDao.countQuestionsByLogin(login));
        userBean.setLang(usersEntity.getLang());


        req.setAttribute("userBean", userBean);
        getServletContext().getRequestDispatcher("/jsp/public/settings_page.jsp").forward(req, resp);
    }
}
