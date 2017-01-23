package servlets;

import beans.RegistrationBean;
import com.sun.org.apache.regexp.internal.RE;
import db.dao.UsersDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.*;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(RegistrationServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String login = req.getParameter("login");

        logger.info("Reg");
        HashMap<String, String> errors = new HashMap<>();

        String regexPassword = "^[a-zA-Z0-9_-]{3,16}$";
        String regexLogin = "^[a-zA-Z0-9_-]{3,15}$";
        String regexEmail = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@" +
                "((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

        UsersDao usersDao = new UsersDao();
        // Проверка пароля
        if (password == null || !checkWithRegExp(password, regexPassword)) {
            errors.put("passwordError", "Error password");
        }

        // Проверка логина
        if (login == null || login.isEmpty()) {
            errors.put("loginError", "Empty login");
        } else if (!checkWithRegExp(login, regexLogin)) {
            errors.put("loginError", "Wrong login");
        } else if (usersDao.isLoginExist(login)) {
            errors.put("loginError", "Login already exist");
        }

        // Проверка почты
        if (email == null || email.isEmpty()) {
            errors.put("emailError", "Empty email");
        } else if (!checkWithRegExp(email, regexEmail)) {
            errors.put("emailError", "Wrong email");
        } else if (usersDao.isEmailExist(email)) {
            errors.put("emailError", "Email already exist");
        }

        if (errors.size() == 0) {
            RegistrationBean bean = new RegistrationBean();
            bean.setEmail(email);
            bean.setLogin(login);
            bean.setPassword(password);
            registerUser(bean);
            logger.info("User " + login + " reg");
            resp.sendRedirect("/");
        } else {
            req.setAttribute("errors",errors);
            req.getRequestDispatcher("/jsp/auth/registration.jsp").forward(req, resp);
        }
    }

    public void registerUser(RegistrationBean bean) {
        UsersDao dao = new UsersDao();
//        if (!dao.isEmailExist(bean.getEmail()) && !dao.isLoginExist(bean.getLogin())) {
        dao.save(bean.toEntity());
//            System.out.println("YES");
//        } else System.out.println("NO");
    }

    public boolean checkWithRegExp(String str, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
