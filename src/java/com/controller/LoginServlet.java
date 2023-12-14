package com.controller;

import com.errors.ValidationError;
import com.model.User;

import com.model.Admin;
import com.validator.Validator;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends InitServlet implements Jumpable {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        
        ValidationError errors = new ValidationError();
        Validator.validate(login, pass, errors);
        RequestDispatcher rd;
        if (!errors.getErrorList().isEmpty()) {
            request.setAttribute("result", errors);
            rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp");
            rd.forward(request, response);
            return;
        }

        
        User user = userService.login(login, pass);
        Admin admin = adminService.login(login, pass);

        
        if (user != null) {
            request.getSession().setAttribute("name", user.getName());
            jump("/WEB-INF/jsp/cabinet.jsp", request, response);
        } else if (admin != null) {

            jump("/WEB-INF/jsp/adminF.jsp", request, response);

        } else {
             Locale userLocale = request.getLocale();

        // Load the appropriate ResourceBundle based on the user's locale
        ResourceBundle bundle = ResourceBundle.getBundle("com.localization.messages.msg", userLocale);

        // Use the ResourceBundle to get the localized messages
        String failureMessage = bundle.getString("error.log");

            request.setAttribute("error", failureMessage);
            jump("/WEB-INF/jsp/error.jsp", request, response);
        }

    }
}
