/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller;

import com.model.Patient;
import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends InitServlet implements Jumpable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Set<Patient> patients = patientService.read();// Получение списка абитуриентов из сервиса
        Set<Patient> patient = new HashSet<>();
        for (Patient a : patients) {
            if (a.getId() == Integer.parseInt(id)) {
                patient.add(a);
            }
        }

        request.setAttribute("patient", patient);
        jump("/WEB-INF/jsp/update.jsp", request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        String surname = request.getParameter("surname");
        String name = request.getParameter("name");
        String patronymic = request.getParameter("patronymic");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        int cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
        String diagnosis = request.getParameter("diagnosis");
        int age = Integer.parseInt(request.getParameter("age"));

        boolean isPatientUpdate = patientService.update(id, surname, name, patronymic, address, phone, cardNumber, diagnosis, age);

         Locale userLocale = request.getLocale();

        // Load the appropriate ResourceBundle based on the user's locale
        ResourceBundle bundle = ResourceBundle.getBundle("com.localization.messages.msg", userLocale);

        // Use the ResourceBundle to get the localized messages
        String successMessage = bundle.getString("error.dataUpdate");
        String failureMessage = bundle.getString("error.dataNotUpdate");

        // Set the appropriate message attribute
        request.setAttribute("error", isPatientUpdate ? successMessage : failureMessage);
        
        jump("/WEB-INF/jsp/error.jsp", request, response);

    }

}
