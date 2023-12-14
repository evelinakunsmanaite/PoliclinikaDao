package com.controller;

import java.io.IOException;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "LocalServlet", urlPatterns = {"/LocalServlet"})
public class LocalServlet extends HttpServlet {

    private void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strLocal = request.getParameter("locale"); //берём локаль из запроса 
        Locale locale = "en".equals(strLocal) ? Locale.US : Locale.getDefault(); //определяем текущую локаль
        String valueCookieLanguage = locale.getLanguage(); //берём из локали язык
        Cookie localeCookieLanguage = new Cookie("locale", valueCookieLanguage);//создаём кукисы, и устанавливаем переданный язык
        response.addCookie(localeCookieLanguage);
        response.setLocale(locale);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.html");//перенаправление
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }
}