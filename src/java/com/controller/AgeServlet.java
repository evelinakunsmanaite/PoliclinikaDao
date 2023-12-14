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

@WebServlet(name = "AgeServlet", urlPatterns = {"/ageServlet"})
public class AgeServlet extends InitServlet implements Jumpable {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Получение пациентов с возрастом старше введенного
        int ag = Integer.parseInt(request.getParameter("age"));

        //Добавление всех пациентов в результат и вывод информации о каждом пациенте
        List<Patient> result = patientService.getAge(ag);

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
