package com.controller;

import com.model.Patient;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FullServlet", urlPatterns = {"/fullServlet"})
public class FullServlet  extends InitServlet implements Jumpable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Получение полного списка пациентов
        Set<Patient> patient = patientService.read();

        if(!patient.isEmpty()){
        //Получение результата по парметрам запроса
        request.setAttribute("result", patient);
        
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
