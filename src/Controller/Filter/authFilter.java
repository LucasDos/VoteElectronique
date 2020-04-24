package Controller.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/candidats"})
public class authFilter implements Filter {
    public static final String LOGIN_REDIRECT = "LOGIN_REDIRECT";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        if(session != null && session.getAttribute("admin") == Boolean.TRUE) {
            req.setAttribute(LOGIN_REDIRECT, req.getRequestURI());
            req.getRequestDispatcher("/candidatsAdmin").forward(req, res);
        } else {
            req.setAttribute(LOGIN_REDIRECT, req.getRequestURI());
            req.getRequestDispatcher("/candidats").forward(req, res);
        }

        /*
        if(req.getSession(false) != null && req.getSession(false).getAttribute("logged") != Boolean.TRUE) {
            req.setAttribute(LOGIN_REDIRECT, req.getRequestURI());
            req.getRequestDispatcher("/candidats").forward(req, res);
            return;
        } else {
            //check admin
        }

        chain.doFilter(req, res);

         */
    }
}
