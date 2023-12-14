package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrew
 */
@WebServlet(name = "PageServlet", urlPatterns = {"/page"})
public class PageServlet extends HttpServlet implements Jumpable {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String page = request.getParameter("page");

        if (null != page) switch (page) {
            case "toLogin" -> jump("/WEB-INF/jsp/index.jsp", request, response);
            case "toAdmin" -> jump("/WEB-INF/jsp//adminF.jsp", request, response);
            case "toUser" -> jump("/WEB-INF/jsp/cabinet.jsp", request, response);
            default -> jump("/WEB-INF/jsp/index.jsp", request, response);
        } 

    }
}
