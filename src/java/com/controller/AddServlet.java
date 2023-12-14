/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller;

import com.model.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "AddServlet", urlPatterns = {"/AddServlet"})
public class AddServlet extends InitServlet implements Jumpable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        jump("/WEB-INF/jsp/adminAdd.jsp", request, response);
    }//сработывает при нажатии на ссылку добавить 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String surname = request.getParameter("surname");
        String name = request.getParameter("name");
        String patronymic = request.getParameter("patronymic");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        int cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
        String diagnosis = request.getParameter("diagnosis");
        int age = Integer.parseInt(request.getParameter("age"));

        // Создаем объект абитуриента
        Patient patient = new Patient(surname, name, patronymic, address, phone, cardNumber, diagnosis, age);

        boolean isPatientAdd = patientService.create(patient);
   Locale userLocale = request.getLocale();

        // Load the appropriate ResourceBundle based on the user's locale
        ResourceBundle bundle = ResourceBundle.getBundle("com.localization.messages.msg", userLocale);

        // Use the ResourceBundle to get the localized messages
        String successMessage = bundle.getString("error.dataAdded");
        String failureMessage = bundle.getString("error.dataNotAdded");

        // Set the appropriate message attribute
        request.setAttribute("error", isPatientAdd ? successMessage : failureMessage);

            jump("/WEB-INF/jsp/error.jsp", request, response);

}
}