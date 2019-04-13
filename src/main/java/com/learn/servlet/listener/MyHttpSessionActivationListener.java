package com.learn.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener()
public class MyHttpSessionActivationListener implements HttpSessionActivationListener {

    public MyHttpSessionActivationListener() {
        System.out.println(">> MyHttpSessionActivationListener - INIT");
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {

    }
}