package com.learn.servlet.controller;

import com.learn.servlet.entity.MockEntityA;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "MVCMockController")
public class MVCMockController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("requestAttribute", new MockEntityA());
        request.getSession().setAttribute("sessionAttribute", new MockEntityA());
        request.getServletContext().setAttribute("servletContextAttribute", new MockEntityA());

        request.setAttribute("test", "request");
        request.getSession().setAttribute("test", "session");
        request.getServletContext().setAttribute("test", "servletContext");

        request.getRequestDispatcher("mvcMockView.jsp").forward(request, response);
    }
}
