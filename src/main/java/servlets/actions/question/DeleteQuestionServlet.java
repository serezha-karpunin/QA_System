package servlets.actions.question;

import db.dao.AnswersDao;
import db.dao.QuestionsDao;
import db.entities.AnswersEntity;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete_question")
public class DeleteQuestionServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(DeleteQuestionServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int question_id = 0;

        Cookie[] cookies = req.getCookies();
        if(cookies!=null) {
            for (Cookie c : cookies) {
                if("id_question_to_delete".equals(c.getName())){
                    question_id = Integer.parseInt(c.getValue());
                    Cookie cookie = new Cookie(c.getName(),c.getValue());
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                    break;
                }
            }
        }

        if(question_id!=0){
            QuestionsDao questionDao = new QuestionsDao();
            AnswersDao answersDao = new AnswersDao();

            for (AnswersEntity ae:answersDao.getAnswersByQuestionId(question_id)) {
                answersDao.deleteById(ae.getIdAnswer());
            }

            questionDao.deleteById(question_id);

            logger.info("Question(id = " + question_id + ") was removed");
            String referer = req.getHeader("referer");
            if(referer.contains("question_page")){
                resp.sendRedirect("/");
            }else{
                resp.sendRedirect(referer.replaceAll("http://localhost:8080", ""));
            }
        }
    }
}
