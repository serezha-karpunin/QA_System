package servlets.pages;

import beans.UserSettingsBean;
import db.dao.UsersDao;
import db.entities.UsersEntity;
import db.util.EntityUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user_settings")
public class SettingsPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/jsp/public/error_page.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("userLogin");

        if(login == null) {
            resp.sendRedirect("/jsp/public/error_page.jsp");
            return;
        }

        UsersDao usersDao = new UsersDao();
        UsersEntity usersEntity = usersDao.getById(login);
        UserSettingsBean userBean = EntityUtil.createUserSettingsBean(usersEntity);

        req.setAttribute("userBean", userBean);
        getServletContext().getRequestDispatcher("/jsp/public/settings_page.jsp").forward(req, resp);
    }
}
