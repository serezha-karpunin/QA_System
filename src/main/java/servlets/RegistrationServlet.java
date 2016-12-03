package servlets;

import beans.RegistrationBean;
import db.dao.UsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RegistrationBean bean = new RegistrationBean(req.getParameter("login"),req.getParameter("email"),req.getParameter("password"));

        registerUser(bean);
        resp.sendRedirect("/");

    }

    public void registerUser(RegistrationBean bean){
        UsersDao dao = new UsersDao();
        dao.create(bean.toEntity());
    }
}
