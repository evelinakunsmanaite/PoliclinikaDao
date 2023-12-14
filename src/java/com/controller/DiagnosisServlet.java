package com.controller;

import com.model.Patient;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DiagnosisServlet", urlPatterns = {"/diagnosisServlet"})
public class DiagnosisServlet extends InitServlet implements Jumpable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
            String diagnosis = request.getParameter("diagnosis"); // Получаем значение параметра "diagnosis" из запроса

           List<Patient> result = patientService.getDiagnosis(diagnosis);

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
