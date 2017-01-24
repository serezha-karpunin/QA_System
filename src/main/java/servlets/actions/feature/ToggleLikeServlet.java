package servlets.actions.feature;

import db.dao.LikesDao;
import db.entities.LikesEntity;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/toggle_like")
public class ToggleLikeServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(ToggleLikeServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/jsp/public/error_page.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("userLogin");
        int idAnswer =Integer.parseInt(req.getParameter("idAnswer"));
        boolean addLike = Boolean.parseBoolean(req.getParameter("addLike"));

        LikesDao ld = new LikesDao();
        LikesEntity entity = new LikesEntity();

        if(addLike){
            logger.info("User " + login + " liked answer(id = " + idAnswer + ")" );
            entity.setLogin(login);
            entity.setIdAnswer(idAnswer);
            ld.save(entity);
        }else{
            ld.delete(login,idAnswer);
            logger.info("User " + login + " disliked answer(id = " + idAnswer + ")" );
        }
    }
}
