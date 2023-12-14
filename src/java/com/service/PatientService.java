/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.model.Patient;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public interface PatientService {
    boolean create(Patient patient);

    Set<Patient> read();

    public boolean delete(int id);

    boolean update(int id, String surname, String name, String patronymic, String address, String phone, int cardNumber, String diagnosis, int age);
    
    List<Patient> getAge(int age);
    
    List<Patient> getDiagnosis(String diagnosis);
    
    public List<Patient> getCardNumber(int start, int end);

}
