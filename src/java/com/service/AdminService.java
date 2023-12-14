/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.model.Admin;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public interface AdminService {
    
        Set<Admin> read();
        
        Admin login(String login, String password);
        
}
