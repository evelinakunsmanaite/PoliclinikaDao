package com.init;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class ServletListener implements ServletContextListener {//отслеживает изменения в контексте

    @SuppressWarnings("unused")
    private DataSource datasource;

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {//доступен для всех сервлетов из нашего проекта
        InitialContext initContext;
        try {
            initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");//ищет окружение 
            datasource = (DataSource) envContext.lookup("jdbc/policlinika");//ищет в окружение по имени; добавляем соединения к сервлетам для дальнейшй работы
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
