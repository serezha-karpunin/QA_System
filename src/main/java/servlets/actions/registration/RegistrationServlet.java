package servlets.actions.registration;

import beans.RegistrationBean;
import db.dao.UsersDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(RegistrationServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String confirm_password = req.getParameter("confirm_password");

        logger.info("Reg");

        String regexPassword = "^[a-zA-Z0-9_-]{3,16}$";
        String regexLogin = "^[a-zA-Z0-9_-]{3,15}$";
        String regexEmail = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@" +
                "((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

        List<String> errors = new ArrayList<>();

        UsersDao usersDao = new UsersDao();

        // Проверка почты
        if (email == null || email.isEmpty()) {
            errors.add("email_missing_error");
        } else if (!checkWithRegExp(email, regexEmail)) {
            errors.add("email_not_valid_error");
        } else if (usersDao.isEmailExist(email)) {
            errors.add("email_already_used_error");
        }

        // Проверка логина
        if (login == null || login.isEmpty()) {
            errors.add("login_missing_error");
        } else if (!checkWithRegExp(login, regexLogin)) {
            errors.add("login_not_valid_error");
        } else if (usersDao.isLoginExist(login)) {
            errors.add("login_already_used_error");
        }

        // Проверка пароля
        if (password == null || password.isEmpty()) {
            errors.add("password_missing_error");
        }else if(!checkWithRegExp(password, regexPassword)){
            errors.add("password_not_valid_error");
        }

        // Проверка подтверждения пароля
        if (confirm_password == null || confirm_password.isEmpty()) {
            errors.add("confirm_password_missing_error");
        }else if(!confirm_password.equals(password)){
            errors.add("confirm_password_not_valid_error");
        }


        if (errors.size()==0) {
            RegistrationBean bean = new RegistrationBean();
            bean.setEmail(email);
            bean.setLogin(login);
            bean.setPassword(password);
            registerUser(bean);
            logger.info("User " + login + " reg");
            resp.sendRedirect("/");
        } else {
            req.setAttribute("current_email",email);
            req.setAttribute("current_login",login);
            for (String s : errors) {
                System.out.println(s);
                resp.addCookie(new Cookie(s,""));
            }
            req.getRequestDispatcher("/jsp/auth/registration.jsp").forward(req, resp);
        }
    }

    public void registerUser(RegistrationBean bean) {
        UsersDao dao = new UsersDao();
        dao.save(bean.toEntity());
    }

    public boolean checkWithRegExp(String str, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
