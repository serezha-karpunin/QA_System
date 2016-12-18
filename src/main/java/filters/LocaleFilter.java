package filters;

import db.dao.UsersDao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.util.Locale;

@WebFilter("/*")
public class LocaleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        boolean isCookieExist = false;

        Cookie[] cookies = httpServletRequest.getCookies();
        if(cookies!=null) {
            for (Cookie c : cookies) {
                if("language".equals(c.getName())){
                    Config.set(httpServletRequest.getSession(), Config.FMT_LOCALE, new Locale(c.getValue()));
                    isCookieExist = true;
                    System.out.println("find cookei");
                    break;
                }
            }
        }

        if(!isCookieExist){
            String login = (String) httpServletRequest.getSession().getAttribute("userLogin");
            if(login!=null){
                UsersDao usersDao = new UsersDao();
                String lang = usersDao.getById(login).getLang();
                Config.set(httpServletRequest.getSession(), Config.FMT_LOCALE, new Locale(lang));
                Cookie c = new Cookie("language", lang);
                httpServletResponse.addCookie(c);
                System.out.println("find in db and added cookei");
            }else{
                System.out.println("set defoualt");
                Config.set(httpServletRequest.getSession(), Config.FMT_LOCALE, Locale.getDefault());
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    @Override
    public void destroy() {

    }
}