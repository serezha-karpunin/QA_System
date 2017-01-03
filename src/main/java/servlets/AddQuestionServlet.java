package servlets;

import db.dao.QuestionsDao;
import db.dao.TagsDao;
import db.entities.QuestionsEntity;
import db.entities.TagsEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


@WebServlet("/add_question")
public class AddQuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");
        String login = (String) req.getSession().getAttribute("userLogin");
        String title = req.getParameter("title");
        String text = req.getParameter("text");
        String tagsString = req.getParameter("tags");

        QuestionsEntity qe = new QuestionsEntity();
        qe.setLogin(login);
        qe.setTitle(title);
        qe.setTextQuestion(text);
        qe.setDateQuestion(new Timestamp(System.currentTimeMillis()));


        QuestionsDao questionsDao = new QuestionsDao();
        int id_question = questionsDao.save(qe);

        if(!"".equals(tagsString)){
            TagsDao td = new TagsDao();

            StringTokenizer st = new StringTokenizer(tagsString.toLowerCase());
            Set<String> tokens = new HashSet<>();

            while(st.hasMoreTokens()){
                tokens.add(st.nextToken());
            }

            for (String tag : tokens) {
                TagsEntity te = new TagsEntity();
                te.setIdQuestion(id_question);
                te.setTag(tag);
                td.save(te);
            }
        }

        resp.sendRedirect("/");
    }
}
