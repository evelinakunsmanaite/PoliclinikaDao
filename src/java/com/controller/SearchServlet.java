package com.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.Patient;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "SearchServlet", urlPatterns = {"/srchServlet"})
public class SearchServlet extends InitServlet implements Jumpable {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
            // Получение параметра запроса
            int start = Integer.parseInt(request.getParameter("start"));
            int end = Integer.parseInt(request.getParameter("end"));

           
           List<Patient> result = patientService.getCardNumber(start, end);

        if (!result.isEmpty()) {
            //Получение результата по парметрам запроса
            request.setAttribute("result", result);
            jump("/WEB-INF/jsp/result.jsp", request, response);
        } else {
 Locale userLocale = request.getLocale();

        // Load the appropriate ResourceBundle based on the user's locale
        ResourceBundle bundle = ResourceBundle.getBundle("com.localization.messages.msg", userLocale);

        // Use the ResourceBundle to get the localized messages
        String failureMessage = bundle.getString("error.dataNotExist");

            request.setAttribute("error", failureMessage);
            jump("/WEB-INF/jsp/error.jsp", request, response);
        }
    }
}
