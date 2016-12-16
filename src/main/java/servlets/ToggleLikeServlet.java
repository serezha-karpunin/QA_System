package servlets;

import db.dao.LikesDao;
import db.entities.LikesEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/toggle_like")
public class ToggleLikeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("userLogin");
        int idAnswer =Integer.parseInt(req.getParameter("idAnswer"));
        boolean addLike = Boolean.parseBoolean(req.getParameter("addLike"));

        LikesDao ld = new LikesDao();
        LikesEntity entity = new LikesEntity();

        if(addLike){
            entity.setLogin(login);
            entity.setIdAnswer(idAnswer);
            ld.save(entity);
        }else{
            ld.delete(login,idAnswer);
        }
    }
}
