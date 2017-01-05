package servlets;

import db.dao.UsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by n on 04.12.2016.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersDao dao = new UsersDao();
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (dao.isUserCorrect(login, password)) {
            req.getSession().setAttribute("userLogin", login);

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
