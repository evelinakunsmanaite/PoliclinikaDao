/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.model.User;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public interface UserService {
    
    Set<User> read();

    User login(String login, String password);
}
