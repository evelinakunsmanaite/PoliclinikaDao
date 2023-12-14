/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.impl;

import com.dao.AdminDao;
import com.model.Admin;
import com.service.AdminService;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public class AdminServiceImpl  implements AdminService {
    AdminDao dao;

    public AdminServiceImpl(AdminDao dao) {
        this.dao = dao;
    }

    @Override
    public Set<Admin> read() {
        return dao.read();
    }

  public Admin login(String login, String password) {
        return dao.read().stream()
                .filter(admin -> login.equals(admin.getLogin())
                && password.equals(admin.getPassword()))
                .findFirst()
                .orElse(null);
    }
}
