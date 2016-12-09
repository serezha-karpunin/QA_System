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

        RegistrationBean bean = new RegistrationBean();
        bean.setEmail(req.getParameter("email"));
        bean.setLogin(req.getParameter("login"));
        bean.setPassword(req.getParameter("password"));
        registerUser(bean);
//        getServletContext().getRequestDispatcher("/jsp/auth/registration.jsp").forward(req, resp);
        resp.sendRedirect("/");
        System.out.println("hello");
    }

    public void registerUser(RegistrationBean bean) {
        UsersDao dao = new UsersDao();
//        if (!dao.isEmailExist(bean.getEmail()) && !dao.isLoginExist(bean.getLogin())) {
            dao.create(bean.toEntity());
//            System.out.println("YES");
//        } else System.out.println("NO");
    }
}
