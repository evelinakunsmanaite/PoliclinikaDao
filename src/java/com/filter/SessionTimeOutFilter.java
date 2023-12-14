package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@WebFilter(urlPatterns = {"/ageServlet","/diagnosisServlet","/srchServlet","/fullServlet"})
public class SessionTimeOutFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;//преобразование для получения доступа к HTTP-запросу
        HttpSession session = httpRequest.getSession(false);//получение текущего сеанса, если не существует, то null
        if (session != null && !session.isNew()) {//проверка существования сеанса и является ли он новым
            chain.doFilter(request, response);//фильтр завершает свою работу и передёт по цепи другому фильтру/целевому сервлету
        } else {
            if (session != null) {
                session.invalidate();//завершение сеанса
            }
            request.getRequestDispatcher("/WEB-INF/jsp/sessionOut.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
