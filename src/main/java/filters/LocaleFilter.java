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
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("language".equals(c.getName())) {
                    Config.set(httpServletRequest.getSession(), Config.FMT_LOCALE, new Locale(c.getValue()));
                    isCookieExist = true;
                    break;
                }
            }
        }

        if (!isCookieExist) {
            String login = (String) httpServletRequest.getSession().getAttribute("userLogin");
            if (login != null) {
                UsersDao usersDao = new UsersDao();
                if (httpServletRequest.getSession().getAttribute("userImage") == null) {
                    httpServletRequest.getSession().setAttribute("userImage", usersDao.getById(login).getImageLink());
                }
                String lang = usersDao.getById(login).getLang();
                Config.set(httpServletRequest.getSession(), Config.FMT_LOCALE, new Locale(lang));
                Cookie c = new Cookie("language", lang);
                httpServletResponse.addCookie(c);
            } else {
                Config.set(httpServletRequest.getSession(), Config.FMT_LOCALE, Locale.getDefault().getLanguage());
            }
        }

        httpServletRequest.setCharacterEncoding("utf-8");

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    @Override
    public void destroy() {

    }
}