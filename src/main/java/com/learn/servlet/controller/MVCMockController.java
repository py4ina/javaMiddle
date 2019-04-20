package com.learn.servlet.controller;

import com.learn.servlet.entity.MockEntityA;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class MVCMockController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("requestAttribute", new MockEntityA());

        HttpSession session = request.getSession();
        session.setAttribute("sessionAttribute", new MockEntityA());

        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("servletContextAttribute", new MockEntityA());

        request.setAttribute("test", "request");
        request.getSession().setAttribute("test", "session");
        request.getServletContext().setAttribute("test", "servletContext");

        request.getRequestDispatcher("mvcMockView.jsp").forward(request, response);
    }
}