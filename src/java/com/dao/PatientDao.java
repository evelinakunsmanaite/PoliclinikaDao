/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.Patient;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public interface PatientDao {
    
    int create(Patient patient);

    Set<Patient> read();

    int update(Patient patient);

    int delete(Patient patient);
}
