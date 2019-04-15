package com.learn.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class MyServletContextListener implements ServletContextListener {

    public MyServletContextListener() {
        System.out.println(">> MyServletContextListener - NEW");
    }
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(">> ServletContext - created, contextPath = " + sce.getServletContext());
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println(">> ServletContext - destroyed, contextPath = " + sce.getServletContext());
    }
}