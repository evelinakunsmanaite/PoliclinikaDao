/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.impl;

import com.dao.UserDao;
import com.model.User;
import com.service.UserService;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public class UserServiceImpl implements UserService{
    UserDao dao;

    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public Set<User> read() {
        return dao.read();
    }

  public User login(String login, String password) {
        return dao.read().stream()
                .filter(user -> login.equals(user.getLogin())
                && password.equals(user.getPassword()))
                .findFirst()
                .orElse(null);
    }
    
}
