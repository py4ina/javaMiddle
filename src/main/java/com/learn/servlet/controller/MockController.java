package com.learn.servlet.controller;

import com.learn.servlet.entity.MockEntityA;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MockController extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("requestAttribute", new MockEntityA());
        request.getSession().setAttribute("sessionAttribute", new MockEntityA());
        request.getServletContext().setAttribute("servletContextAttribute", );

        request.setAttribute("test", "request");
        request.getSession().setAttribute("test", "session");
        request.getServletContext().setAttribute("test", "servletContext");

        request.getRequestDispatcher("mvcMockView.jsp").forward(request, response);
    }
}