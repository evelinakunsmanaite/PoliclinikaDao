/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.User;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public interface UserDao {
    Set<User> read();
}
