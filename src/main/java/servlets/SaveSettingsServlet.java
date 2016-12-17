package servlets;

import db.dao.UsersDao;
import db.entities.UsersEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/save_settings")
public class SaveSettingsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = (String) req.getSession().getAttribute("userLogin");
        if(login == null) resp.sendRedirect("/");

        String lang = req.getParameter("language");
        System.out.println("lananana " + lang);

        UsersDao usersDao = new UsersDao();
        UsersEntity usersEntity = usersDao.getById(login);
        usersEntity.setLang(lang);
        usersDao.update(usersEntity);
        req.setAttribute("saved", true);
        req.getRequestDispatcher("/user_settings").forward(req,resp);
    }
}
