package com.controller;

import com.dao.AdminDao;
import com.dao.PatientDao;
import com.dao.UserDao;
import com.dao.impl.AdminDaoImpl;
import com.dao.impl.PatientDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.service.AdminService;
import com.service.PatientService;
import com.service.UserService;
import com.service.impl.AdminServiceImpl;
import com.service.impl.PatientServiceImpl;
import com.service.impl.UserServiceImpl;
import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;

public abstract class InitServlet extends HttpServlet {

    private @Resource(name = "jdbc/policlinika")//испальзование листнера
    DataSource dataSource;
    protected UserDao userDao;
    protected PatientDao patientDao;
    protected UserService userService;
    protected PatientService patientService;
    protected AdminDao adminDao;
    protected AdminService adminService;
    @Override
    public void init() {//инициализация объектов с которыми работает сервлеты
        userDao = new UserDaoImpl(dataSource);
        userService = new UserServiceImpl(userDao);
        patientDao = new PatientDaoImpl(dataSource);
        patientService = new PatientServiceImpl(patientDao);
        adminDao = new AdminDaoImpl(dataSource);
        adminService = new AdminServiceImpl(adminDao);
    }
}
