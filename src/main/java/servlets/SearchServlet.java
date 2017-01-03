package servlets;

import beans.QuestionListBean;
import db.dao.QuestionsDao;
import db.dao.UsersDao;
import db.entities.QuestionsEntity;
import db.entities.UsersEntity;
import db.util.EntityUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchString = req.getParameter("searchString");

        Set<QuestionsEntity> suitableQuestions = new HashSet<>();

        if(!"".equals(searchString)){

            UsersDao usersDao = new UsersDao();
            QuestionsDao questionsDao = new QuestionsDao();


            StringTokenizer st = new StringTokenizer(searchString);
            while(st.hasMoreTokens()){
                String key = st.nextToken();

                UsersEntity ue = usersDao.getById(key);
                if (ue != null) {
                    suitableQuestions.addAll(questionsDao.getQuestionsByLogin(key));
                }

                for (QuestionsEntity entity : questionsDao.getLastQuestions()) {
                    if(entity.getTitle().toLowerCase().contains(key.toLowerCase())){
                        suitableQuestions.add(entity);
                    }
                }

                suitableQuestions.addAll(questionsDao.getQuestionsByTag(key.toLowerCase()));

            }
        }

        if(suitableQuestions.size()!=0){
            List<QuestionListBean> searchResults = new ArrayList<>();
            for (QuestionsEntity entity : suitableQuestions) {
                searchResults.add(EntityUtil.createQuestionListBean(entity));
            }
            req.setAttribute("searchResults", searchResults);
        }

        req.setAttribute("searchString", searchString);
        getServletContext().getRequestDispatcher("/jsp/public/search_results_page.jsp").forward(req, resp);
    }
}
