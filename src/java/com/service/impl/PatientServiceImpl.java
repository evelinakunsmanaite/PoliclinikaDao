/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.impl;

import com.dao.PatientDao;
import com.model.Patient;
import com.service.PatientService;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Administrator
 */
public class PatientServiceImpl implements PatientService {

    PatientDao dao;

    public PatientServiceImpl(PatientDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean create(Patient patient) {
        return dao.create(patient) > 0;
    }

    @Override
    public Set<Patient> read() {
        return dao.read();
    }

    @Override
    public boolean update(int id, String surname, String name, String patronymic, String address, String phone, int cardNumber, String diagnosis, int age) {
        Patient updatedPatient = new Patient(id, surname, name, patronymic, address, phone, cardNumber, diagnosis, age);
        return dao.update(updatedPatient) > 0;
    }

    @Override
    public boolean delete(int id) {
        Patient patient = new Patient(id);
        return dao.delete(patient) > 0;
    }
    
    @Override
    public List<Patient> getAge(int age) {
return dao.read().stream()
                .filter(patient -> age == patient.getAge())
        .collect(Collectors.toList());

    }
    
    @Override
    public List<Patient> getDiagnosis(String diagnosis) {
    return dao.read().stream()
                .filter(patient -> diagnosis.equals(patient.getDiagnosis()) )
        .collect(Collectors.toList());
    }
    
    @Override
    public List<Patient> getCardNumber(int start, int end) {
 return dao.read().stream()
            .filter(patient -> patient.getCardNumber() >= start && patient.getCardNumber() <= end)
            .collect(Collectors.toList());

}
}