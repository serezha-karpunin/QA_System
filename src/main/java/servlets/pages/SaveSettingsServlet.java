package servlets.pages;

import db.dao.UsersDao;
import db.entities.UsersEntity;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.jsp.jstl.core.Config;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

@WebServlet("/save_settings")
@MultipartConfig
public class SaveSettingsServlet extends HttpServlet {
    private static final String SAVE_DIR = "uploadFiles";
    final static Logger logger = Logger.getLogger(SaveSettingsServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/jsp/public/error_page.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = (String) req.getSession().getAttribute("userLogin");
        if(login == null) {
            resp.sendRedirect("/jsp/public/error_page.jsp");
            return;
        }
        String lang = req.getParameter("language");

        logger.info("User " + login + "set language to " + lang);
        UsersDao usersDao = new UsersDao();
        UsersEntity usersEntity = usersDao.getById(login);
        usersEntity.setLang(lang);

        Cookie c = new Cookie("language", "nothing");
        c.setMaxAge(0);
        resp.addCookie(c);

        Config.set(req.getSession(), Config.FMT_LOCALE, new Locale(lang));


        String appPath = req.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + SAVE_DIR;

        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        for (Part part : req.getParts()) {
            if (part.getContentType() == null || extractFileName(part).isEmpty()) continue; // можно еще над этим подумать
            String fileName = extractFileName(part);
            fileName = new File(fileName).getName();
            part.write(savePath + File.separator + fileName);
            System.out.println(savePath + File.separator + fileName);
            usersEntity.setImageLink(SAVE_DIR + File.separator + fileName);
            req.getSession().setAttribute("userImage", SAVE_DIR + File.separator + fileName);
            logger.info("User " + login + "change avatar to " + SAVE_DIR+File.separator+fileName);
        }
        usersDao.update(usersEntity);


        req.setAttribute("saved", true); // ???
        req.getRequestDispatcher("/user_settings").forward(req,resp);
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
