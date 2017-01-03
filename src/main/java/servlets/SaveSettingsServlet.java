package servlets;

import db.dao.UsersDao;
import db.entities.UsersEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.util.Locale;

@WebServlet("/save_settings")
public class SaveSettingsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("userLogin");
        if(login == null) {
            resp.sendRedirect("/");
            return;
        }

        String lang = req.getParameter("language");

        UsersDao usersDao = new UsersDao();
        UsersEntity usersEntity = usersDao.getById(login);
        usersEntity.setLang(lang);
        usersDao.update(usersEntity);

        Cookie c = new Cookie("language", "nothing");
        c.setMaxAge(0);
        resp.addCookie(c);

        Config.set(req.getSession(), Config.FMT_LOCALE, new Locale(lang));

        req.setAttribute("saved", true);
        req.getRequestDispatcher("/user_settings").forward(req,resp);
    }
}
