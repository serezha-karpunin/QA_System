package servlets.actions.auth;

import db.dao.UsersDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/jsp/public/error_page.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersDao dao = new UsersDao();
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (login == null || password == null) {
            resp.sendRedirect("/jsp/public/error_page.jsp");
            return;
        }


        if (dao.isUserCorrect(login, password)) {
            if(login.contains("@")) login = dao.getLoginByEmail(login);
            req.getSession().setAttribute("userLogin", login);
            String displayedLogin = (login.length() < 8) ? login : login.substring(0, 7) + "..";
            req.getSession().setAttribute("displayedLogin", displayedLogin);
            req.getSession().setAttribute("userImage", dao.getById(login).getImageLink());

            logger.info("User " + login + " log in ");
            Cookie c = new Cookie("language", "nothing");
            c.setMaxAge(0);
            resp.addCookie(c);

            resp.sendRedirect("/");
        } else {
            req.setAttribute("errorMessage", "Error");
            req.getRequestDispatcher("/jsp/auth/login.jsp").forward(req, resp);
        }
    }
}
