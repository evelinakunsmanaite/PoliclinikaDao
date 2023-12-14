package com.filter;

import java.io.IOException;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrator
 */
@WebFilter(urlPatterns = {"/*"})
public class LocaleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request; //приведение типа в http
        Cookie[] cookies = httpRequest.getCookies(); //создаём массив кукисов, взятых из запроса
        String strLocale = Optional.ofNullable(cookies).map(Stream::of) // если кукисы не пкстые создаём стрим кукисов
                .orElseGet(Stream::empty) // если пустой стрим
                .filter(c -> "locale".equals(c.getName())) //фильтрует нужную локаль
                .findAny().orElse(new Cookie("locale", "ru")) //возвращает всё что нашёл, если ненайден создаёт новые
                .getValue();//возвращает значение
        request.getServletContext().setAttribute("locale", strLocale);
        Locale locale = "en".equals(strLocale) ? Locale.US : Locale.getDefault();//определяем локаль
        response.setLocale(locale);//записываем в ответ локаль
        chain.doFilter(request, response);//отправляем дальше по цепочке
    }

    @Override
    public void destroy() {
    }
}
