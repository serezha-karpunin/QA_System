package servlets;

import db.dao.AnswersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete_answer")
public class DeleteAnswerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int answer_id = 0;

        Cookie[] cookies = req.getCookies();
        if(cookies!=null) {
            for (Cookie c : cookies) {
                if("id_answer_to_delete".equals(c.getName())){
                    answer_id = Integer.parseInt(c.getValue());
                    Cookie cookie = new Cookie(c.getName(),c.getValue());
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                    break;
                }
            }
        }
        if(answer_id!=0){
            AnswersDao answersDao = new AnswersDao();
            answersDao.deleteById(answer_id);
            resp.sendRedirect(req.getHeader("referer").replaceAll("http://localhost:8080", ""));
        }


    }
}
