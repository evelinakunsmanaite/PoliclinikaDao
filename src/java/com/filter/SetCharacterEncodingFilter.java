package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns = {"/*"},
        initParams = {
            @WebInitParam(name = "encoding", value = "UTF-8"),
            @WebInitParam(name = "contentType", value = "text/html;charset=UTF-8")
        })
public class SetCharacterEncodingFilter implements Filter {

    private String encoding;
    private String contentType;

    @Override
    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");
        if (encoding == null) {
            encoding = "UTF-8";
        }

        contentType = config.getInitParameter("contentType");
        if (contentType == null) {
            contentType = "text/html;charset=UTF-8";
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
            throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset=UTF-8");
        next.doFilter(request, response);
    }

    @Override
    public void destroy() {
        encoding = null;
        contentType = null;
    }
}
